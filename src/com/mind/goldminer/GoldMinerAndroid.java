package com.mind.goldminer;

import com.badlogic.gdx.backends.android.AndroidApplication;

import android.os.Bundle;

public class GoldMinerAndroid extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new GoldMiner(), false);
    }
}