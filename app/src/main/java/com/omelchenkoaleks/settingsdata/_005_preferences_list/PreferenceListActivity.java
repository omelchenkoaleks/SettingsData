package com.omelchenkoaleks.settingsdata._005_preferences_list;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.omelchenkoaleks.settingsdata.R;

public class PreferenceListActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_005);
    }
}
