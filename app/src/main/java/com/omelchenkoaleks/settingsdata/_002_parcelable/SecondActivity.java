package com.omelchenkoaleks.settingsdata._002_parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.omelchenkoaleks.settingsdata.R;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "parcelable";

    private TextView mStringTextView;
    private TextView mIntTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_002_second);

        mStringTextView = findViewById(R.id.text_from_main_activity_text_view);
        mIntTextView = findViewById(R.id.number_from_main_activity_text_view);

        Log.d(TAG, "getParcelableExtra()");
        MyObject myObject = (MyObject) getIntent()
                .getParcelableExtra(MyObject.class.getCanonicalName());
        Log.d(TAG, "myObject: " + myObject.getFieldString() + ", " + myObject.getFieldInt());

        mStringTextView.setText(myObject.getFieldString());
        mIntTextView.setText(Integer.toString(myObject.getFieldInt()));
    }
}
