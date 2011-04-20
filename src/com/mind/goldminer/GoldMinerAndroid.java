package com.mind.goldminer;

import com.badlogic.gdx.backends.android.AndroidApplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class GoldMinerAndroid extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initialize(new GoldMiner(), false);
    }
}