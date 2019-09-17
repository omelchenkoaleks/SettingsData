package com.omelchenkoaleks.settingsdata._003_saved_rotation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.settingsdata.R;

public class SavedActivity extends AppCompatActivity {
    private static final String TAG = "SavedActivity";

    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_003_saved);

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // восстанавливаем данные с помощью объекта savedInstanceState
        mCount = savedInstanceState.getInt("counter");

        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // оохраняем данные в объект outState
        outState.putInt("counter", mCount);

        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
    }

    public void countOnClick(View view) {
        Toast.makeText(this, "count: " + ++mCount, Toast.LENGTH_SHORT).show();
    }
}
