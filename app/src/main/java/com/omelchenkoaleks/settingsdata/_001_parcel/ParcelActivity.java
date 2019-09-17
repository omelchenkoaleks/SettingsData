package com.omelchenkoaleks.settingsdata._001_parcel;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.settingsdata.R;

public class ParcelActivity extends AppCompatActivity {
    private static final String TAG = "ParcelActivity";

    /*
        Parcel - это объект для передачи данных. У него есть много
        методов для помещения и извлечения данных.
     */
    private Parcel mParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_001_parcel);

        writeParcel();
        readParcel();
    }

    private void writeParcel() {
        mParcel = Parcel.obtain();

        byte b = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        String s = "string";

        logWriteInfo("Before writing");
        mParcel.writeByte(b);
        logWriteInfo("byte");
        mParcel.writeInt(i);
        logWriteInfo("int");
        mParcel.writeLong(l);
        logWriteInfo("long");
        mParcel.writeFloat(f);
        logWriteInfo("float");
        mParcel.writeDouble(d);
        logWriteInfo("double");
        mParcel.writeString(s);
        logWriteInfo("String");
    }

    private void readParcel() {
        /*
            Каждая запись данных перемещает позицию на кол-во,
            равное размеру записываемых данных.
            Размер всех последовательно записанных данных у нас составил 48,
            и позиция соответственно переместилась в 48.
         */
        logReadInfo("Before reading");

        // устанавливаем позицию в 0
        mParcel.setDataPosition(0);

        // читаем данные
        logReadInfo("byte = " + mParcel.readByte());
        logReadInfo("int = " + mParcel.readInt());
        logReadInfo("long = " + mParcel.readLong());
        logReadInfo("float = " + mParcel.readFloat());
        logReadInfo("double = " + mParcel.readDouble());
        logReadInfo("String = " + mParcel.readString());
    }

    private void logWriteInfo(String text) {
        // dataSize() - это объем записанных данных
        Log.d(TAG, text + ": " + "dataSize = " + mParcel.dataSize());
    }

    private void logReadInfo(String text) {
        Log.d(TAG, text + ": " + "dataPosition = " + mParcel.dataPosition());
    }
}
