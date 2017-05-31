package com.emdroidery.feedme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * The first activity to be shown to the user. The major undertaking
 * of this activity would be accumulate all the available cached/stored data
 * for the user apart from checking if the current location of the user
 * is the preferred location
 *
 * @author farhan
 * @version 1.0
 * @since 31/5/17
 */
public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}