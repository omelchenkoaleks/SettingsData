package com.omelchenkoaleks.settingsdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.settingsdata._001_parcel.ParcelActivity;
import com.omelchenkoaleks.settingsdata._002_parcelable.ParcelableActivity;
import com.omelchenkoaleks.settingsdata._003_saved_rotation.SavedActivity;
import com.omelchenkoaleks.settingsdata._004_preferences_settings.MainPreferenceActivity;
import com.omelchenkoaleks.settingsdata._005_preferences_list.MainPreferencesListActivity;
import com.omelchenkoaleks.settingsdata._007_programmatically_preferences.ProgrammaticallyActivity;
import com.omelchenkoaleks.settingsdata._008_data_storage_sharedpreferences.SharedPreferencesActivity;
import com.omelchenkoaleks.settingsdata.working_with_file.WithFileActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onActivity(View view) {
        switch (view.getId()) {
            case R.id.parcel_button:
                Intent parcelIntent = new Intent(this, ParcelActivity.class);
                startActivity(parcelIntent);
                break;
            case R.id.parcelable_button:
                Intent parcelableIntent = new Intent(this, ParcelableActivity.class);
                startActivity(parcelableIntent);
                break;
            case R.id.saved_button:
                Intent saveRestoreIntent = new Intent(this, SavedActivity.class);
                startActivity(saveRestoreIntent);
                break;
            case R.id.main_preference_button:
                Intent mainPreferenceIntent = new Intent(this, MainPreferenceActivity.class);
                startActivity(mainPreferenceIntent);
                break;
            case R.id.main_preference_list_button:
                Intent mainPreferenceListIntent = new Intent(this, MainPreferencesListActivity.class);
                startActivity(mainPreferenceListIntent);
                break;

            case R.id.main_activity_006_button:
                Intent preferenceActivityIntent = new Intent(this, com.omelchenkoaleks.settingsdata._006_references_activity.MainActivity.class);
                startActivity(preferenceActivityIntent);
                break;
            case R.id.programmatically_button:
                Intent programmaticallyIntent = new Intent(this, ProgrammaticallyActivity.class);
                startActivity(programmaticallyIntent);
                break;
            case R.id.sharedpreferences_button:
                Intent sharedpreferencesIntent = new Intent(this, SharedPreferencesActivity.class);
                startActivity(sharedpreferencesIntent);
                break;
            case R.id.working_file_button:
                Intent workingFileIntent = new Intent(this, WithFileActivity.class);
                startActivity(workingFileIntent);
                break;
        }
    }
}
