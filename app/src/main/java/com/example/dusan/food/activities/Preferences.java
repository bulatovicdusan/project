package com.example.dusan.food.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.dusan.food.R;

/**
 * Created by wubon on 1/12/2017.
 */
public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
