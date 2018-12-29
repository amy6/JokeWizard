package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, ProgressChangeListener {

    private ProgressBar progressBar;
    private InterstitialAd interstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button jokeButton = root.findViewById(R.id.joke_button);
        jokeButton.setOnClickListener(this);

        progressBar = root.findViewById(R.id.progress_bar);

        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");

        interstitialAd = new InterstitialAd(getContext());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        initAds(root);
        return root;
    }

    private void initAds(View root) {
        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        interstitialAd.loadAd(new AdRequest.Builder().build());
    }


    @Override
    public void onClick(View v) {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
            onProgressChanged(true);
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    interstitialAd.loadAd(new AdRequest.Builder().build());
                    new EndpointsAsyncTask(MainActivityFragment.this).execute(getContext());
                }
            });
        } else {
            Toast.makeText(getContext(), "What's that?", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onProgressChanged(boolean complete) {
        progressBar.setVisibility(complete ? View.VISIBLE : View.GONE);
    }
}
