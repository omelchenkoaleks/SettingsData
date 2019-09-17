package com.omelchenkoaleks.settingsdata._002_parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.omelchenkoaleks.settingsdata.R;

public class ParcelableActivity extends AppCompatActivity {
    private static final String TAG = "parcelable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_002_parcelable);
    }

    public void sendOnSecondActivity(View view) {
        MyObject myObject = new MyObject("text", 200);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myObject);

        Log.d(TAG, "startActivity()");
        startActivity(intent);
    }
}
