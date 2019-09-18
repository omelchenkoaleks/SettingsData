package com.omelchenkoaleks.settingsdata._006_references_activity;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

import com.omelchenkoaleks.settingsdata.R;

public class PrefActivity extends PreferenceActivity {
    private CheckBoxPreference mCheckBoxPreference_3;
    private PreferenceCategory mPreferenceCategory_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_006);

        mCheckBoxPreference_3 = (CheckBoxPreference) findPreference("checkbox_3");
        mPreferenceCategory_2 = (PreferenceCategory) findPreference("category_2");
        mPreferenceCategory_2.setEnabled(mCheckBoxPreference_3.isChecked());

        mCheckBoxPreference_3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                mPreferenceCategory_2.setEnabled(mCheckBoxPreference_3.isChecked());
                return false;
            }
        });
    }
}
