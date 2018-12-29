package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, ProgressChangeListener {

    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = root.findViewById(R.id.joke_button);
        jokeButton.setOnClickListener(this);
        progressBar = root.findViewById(R.id.progress_bar);
        return root;
    }

    @Override
    public void onClick(View v) {
        onProgressChanged(true);
        new EndpointsAsyncTask(this).execute(getContext());
    }

    @Override
    public void onProgressChanged(boolean complete) {
        progressBar.setVisibility(complete ? View.VISIBLE : View.GONE);
    }
}
