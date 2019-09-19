package com.omelchenkoaleks.settingsdata._008_data_storage_sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.settingsdata.R;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mSavedEditText;
    private Button mSaveButton;
    private Button mLoadButton;

    private SharedPreferences mSharedPreferences;

    final String DATA_PREFERENCES = "data_preferences";
    final String SAVING_TEXT = "SA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_009_shared_preferences);

        mSavedEditText = findViewById(R.id.save_load_edit_text);

        mSaveButton = findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(this);

        mLoadButton = findViewById(R.id.load_button);
        mLoadButton.setOnClickListener(this);

        // если хотим, чтобы загружались сохраненные данные автоматически (без нажатия на кнопку)
        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_button:
                saveText();
                break;
            case R.id.load_button:
                loadText();
                break;
            default:
                break;
        }
    }

    private void saveText() {
        mSharedPreferences = getSharedPreferences(DATA_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SAVING_TEXT, mSavedEditText.getText().toString());
        editor.apply();

        Toast.makeText(this, "Method saveText()", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        mSharedPreferences = getSharedPreferences(DATA_PREFERENCES, MODE_PRIVATE);
        String savedText = mSharedPreferences.getString(SAVING_TEXT, "");
        mSavedEditText.setText(savedText);

        Toast.makeText(this, "Method loadText", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // если хотим, чтобы сохранялись данные автоматически (без нажатия на кнопку)
        saveText();
        super.onDestroy();
    }
}
