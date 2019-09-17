package com.omelchenkoaleks.settingsdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.settingsdata._001_parcel.ParcelActivity;

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
        }
    }
}
