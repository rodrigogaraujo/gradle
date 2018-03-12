package com.example.myjokeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MyJokeActivity extends AppCompatActivity {

    private TextView mTvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_joke);

        mTvJoke = findViewById(R.id.tv_joke);
        if(getIntent().hasExtra(Constants.SEND_JOKE)){
            mTvJoke.setText(getIntent().getStringExtra(Constants.SEND_JOKE));
        }
    }
}
