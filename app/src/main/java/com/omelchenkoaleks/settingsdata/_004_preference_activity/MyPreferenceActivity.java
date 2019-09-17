package com.omelchenkoaleks.settingsdata._004_preference_activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.omelchenkoaleks.settingsdata.R;

public class MyPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_004);
    }
}
