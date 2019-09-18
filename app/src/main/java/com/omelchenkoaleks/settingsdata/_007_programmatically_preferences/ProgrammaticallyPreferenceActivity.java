package com.omelchenkoaleks.settingsdata._007_programmatically_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

import com.omelchenkoaleks.settingsdata.R;

public class ProgrammaticallyPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // создаем экран
        PreferenceScreen rootScreen = getPreferenceManager().createPreferenceScreen(this);
        // указываем активити, что это корневой экран
        setPreferenceScreen(rootScreen);


        // далее создаем элементы, присваиваем атрибуты и формируем иерархию

        CheckBoxPreference checkBoxPreference_1 = new CheckBoxPreference(this);
        checkBoxPreference_1.setKey("checkbox_1");
        checkBoxPreference_1.setTitle("CheckBox_1");
        checkBoxPreference_1.setSummaryOff("Description of checkbox 1 off");
        checkBoxPreference_1.setSummaryOn("Description of checkbox 1 on");

        rootScreen.addPreference(checkBoxPreference_1);


        ListPreference listPreference = new ListPreference(this);
        listPreference.setKey("list");
        listPreference.setTitle("List");
        listPreference.setSummary("Description of List");
        listPreference.setEntries(R.array.entries);
        listPreference.setEntryValues(R.array.entry_values);

        rootScreen.addPreference(listPreference);


        CheckBoxPreference checkBoxPreference_2 = new CheckBoxPreference(this);
        checkBoxPreference_2.setKey("checkbox_2");
        checkBoxPreference_2.setTitle("Checkbox_2");
        checkBoxPreference_2.setSummary("Description of checkbox 2");

        rootScreen.addPreference(checkBoxPreference_2);



        PreferenceScreen preferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        preferenceScreen.setKey("screen");
        preferenceScreen.setTitle("Screen");
        preferenceScreen.setSummary("Description of screen");

        final CheckBoxPreference checkBoxPreference_3 = new CheckBoxPreference(this);
        checkBoxPreference_3.setKey("checkbox_3");
        checkBoxPreference_3.setTitle("CheckBox_3");
        checkBoxPreference_3.setSummary("Description of checkbox 3");

        preferenceScreen.addPreference(checkBoxPreference_3);


        PreferenceCategory preferenceCategory_1 = new PreferenceCategory(this);
        preferenceCategory_1.setKey("category_1");
        preferenceCategory_1.setTitle("Category_1");
        preferenceCategory_1.setSummary("Description of category 1");

        preferenceScreen.addPreference(preferenceCategory_1);


        CheckBoxPreference checkBoxPreference_4 = new CheckBoxPreference(this);
        checkBoxPreference_4.setKey("checkbox_4");
        checkBoxPreference_4.setTitle("CheckBox_4");
        checkBoxPreference_4.setSummary("Description of checkbox 4");

        preferenceCategory_1.addPreference(checkBoxPreference_4);


        final PreferenceCategory preferenceCategory_2 = new PreferenceCategory(this);
        preferenceCategory_2.setKey("category_1");
        preferenceCategory_2.setTitle("Category_2");
        preferenceCategory_2.setSummary("Description of category 2");

        preferenceScreen.addPreference(preferenceCategory_2);


        CheckBoxPreference checkBoxPreference_5 = new CheckBoxPreference(this);
        checkBoxPreference_5.setKey("checkbox_5");
        checkBoxPreference_5.setTitle("CheckBox_5");
        checkBoxPreference_5.setSummary("Description of checkbox 5");

        preferenceCategory_2.addPreference(checkBoxPreference_5);


        CheckBoxPreference checkBoxPreference_6 = new CheckBoxPreference(this);
        checkBoxPreference_6.setKey("checkbox_6");
        checkBoxPreference_6.setTitle("CheckBox_6");
        checkBoxPreference_6.setSummary("Description of checkbox 6");

        preferenceCategory_2.addPreference(checkBoxPreference_6);


        rootScreen.addPreference(preferenceScreen);

        listPreference.setDependency("checkbox_1");
        preferenceScreen.setDependency("checkbox_2");



        // код для связи активности, preferenceCategory_2 и значения checkBoxPreference_3
        preferenceCategory_2.setEnabled(checkBoxPreference_3.isChecked());
        checkBoxPreference_3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                preferenceCategory_2.setEnabled(checkBoxPreference_3.isChecked());
                return false;
            }
        });
    }
}
