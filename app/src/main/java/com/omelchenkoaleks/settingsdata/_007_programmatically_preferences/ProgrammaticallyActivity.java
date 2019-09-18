package com.omelchenkoaleks.settingsdata._007_programmatically_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.omelchenkoaleks.settingsdata.R;
import com.omelchenkoaleks.settingsdata._006_references_activity.PrefActivity;

public class ProgrammaticallyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_007_programm_preferences);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(0, 1, 0, "Preferences");
        menuItem.setIntent(new Intent(this, ProgrammaticallyPreferenceActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}
