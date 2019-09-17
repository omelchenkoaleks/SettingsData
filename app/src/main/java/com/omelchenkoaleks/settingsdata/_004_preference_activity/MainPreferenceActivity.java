package com.omelchenkoaleks.settingsdata._004_preference_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.omelchenkoaleks.settingsdata.R;

public class MainPreferenceActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_004_main_preference);

        mInfoTextView = findViewById(R.id.info_pref_text_view);

        // получаем SharedPreferences, который будет работать с файлом настроек
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // полная очистка настроек
//        mSharedPreferences.edit().clear().commit();
    }

    /*
        onResume() = почему здесь выводим нашу информацию на экран, а не в onCreate()?
        Когда мы будем возвращаться с экрана настроек в главное меню, то onCreate()
        не сработает (т.к. окно уже создано и висит в памяти) и изменения мы не увидим.
        А onResume() точно сработает ))).
     */

    @Override
    protected void onResume() {
        Boolean notification = mSharedPreferences.getBoolean("notification", false);
        String address = mSharedPreferences.getString("address", "");
        String text = "Notification are " + ((notification) ? "enabled, address = " + address : "disabled");
        mInfoTextView.setText(text);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(0, 1, 0, "Preferences");
        menuItem.setIntent(new Intent(this, MyPreferenceActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}
