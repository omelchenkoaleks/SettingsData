package com.omelchenkoaleks.settingsdata._002_parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyObject implements Parcelable {
    private static final String TAG = "parcelable";

    private String mFieldString;
    private int mFieldInt;

    public MyObject(String fieldString, int fieldInt) {
        mFieldString = fieldString;
        mFieldInt = fieldInt;
    }

    // конструктор, считывающий данные из Parcel
    private MyObject(Parcel parcel) {
        Log.d(TAG, "MyObject(Parcel parcel)");
        mFieldString = parcel.readString();
        mFieldInt = parcel.readInt();
    }

    public String getFieldString() {
        return mFieldString;
    }

    public int getFieldInt() {
        return mFieldInt;
    }

    // используется для создания нашего MyObject и заполнения его данными из Parcel
    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        // распаковывваем объект из Parcel
        @Override
        public MyObject createFromParcel(Parcel in) {
            Log.d(TAG, "createFromParcel");
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // упаковываем объект в Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.d(TAG, "writeToParcel");
        dest.writeString(mFieldString);
        dest.writeInt(mFieldInt);
    }
}
