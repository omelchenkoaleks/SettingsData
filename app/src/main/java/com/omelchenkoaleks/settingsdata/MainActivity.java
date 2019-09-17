package com.omelchenkoaleks.settingsdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.settingsdata._001_parcel.ParcelActivity;
import com.omelchenkoaleks.settingsdata._002_parcelable.ParcelableActivity;
import com.omelchenkoaleks.settingsdata._003_saved_rotation.SavedActivity;

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
        }
    }
}
