package com.omelchenkoaleks.settingsdata._005_preferences_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.omelchenkoaleks.settingsdata.R;

public class MainPreferencesListActivity extends AppCompatActivity {
    private TextView mInfoTextView;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_005_preferences_list);

        mInfoTextView = findViewById(R.id.info_preference_list_text_view);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected void onResume() {
        String listValue = mSharedPreferences.getString("list", "not chosen");
        mInfoTextView.setText("List value: " + listValue);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(0, 1, 0, "Preferences");
        menuItem.setIntent(new Intent(this, PreferenceListActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}
