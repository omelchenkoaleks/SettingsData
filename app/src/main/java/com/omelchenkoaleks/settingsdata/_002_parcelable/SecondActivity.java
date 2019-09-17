package com.omelchenkoaleks.settingsdata._002_parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.omelchenkoaleks.settingsdata.R;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "parcelable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_002_second);

        Log.d(TAG, "getParcelableExtra()");
        MyObject myObject = (MyObject) getIntent()
                .getParcelableExtra(MyObject.class.getCanonicalName());
        Log.d(TAG, "myObject: " + myObject.getFieldString() + ", " + myObject.getFieldInt());
    }
}
