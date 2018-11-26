package com.example.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = findViewById(R.id.joke_text);

        if (getIntent() != null) {
            if (getIntent().hasExtra("joke")) {
                String joke = getIntent().getStringExtra("joke");
                if (!TextUtils.isEmpty(joke)) {
                    jokeTextView.setText(joke);
                }
            }
        }
    }
}
