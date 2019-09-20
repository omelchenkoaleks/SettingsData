package com.omelchenkoaleks.settingsdata._009_working_with_file;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.omelchenkoaleks.settingsdata.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WithFileActivity extends AppCompatActivity {
    private static final String TAG = "WithFileActivity";

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    final String FILE_NAME = "fileName";
    final String DIR_SD = "myFiles";
    final String FILE_NAME_SD = "fileSD.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_009_with_file);

        verifyStoragePermissions(this);
    }

    /*
        ЭТА ПРОВЕРКА НУЖНА ОБЯЗАТЕЛЬНО, ДАЖЕ ПРИ ОБЪЯВЛЕНИИ РАЗРЕШЕНИЙ В МАНИФЕСТЕ ...
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void onClickButtons(View view) {
        switch (view.getId()) {
            case R.id.write_file_button:
                writeToFile();
                break;
            case R.id.read_file_button:
                readFromFile();
                break;
            case R.id.write_file_sd_button:
                writeToSD();
//                writeFileSD();
                break;
            case R.id.read_file_sd_button:
                readFromSD();
//                readFileSD();
                break;
            default:
                break;
        }
    }

    private void writeToFile() {
        /*
            1, открываем поток для записи
            2, пишем данные
            3, не забываем закрыть поток
         */
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILE_NAME, MODE_PRIVATE)));
            bufferedWriter.write("File data");
            bufferedWriter.close();

            Log.d(TAG, "writeToFile: written");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        /*
            1, открываем поток для чтения
            2, читаем содержимое
         */
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    openFileInput(FILE_NAME)));
            String fileData = "";
            while ((fileData = bufferedReader.readLine()) != null) {
                Log.d(TAG, "readFromFile: " + fileData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeToSD() {
        /*
            1, проверяем доступна ли SD
            2, получаем путь к SD
            3, добавляем свой каталог к пути
            4, создаем каталог
            5, формируем объект File
            6, открываем поток для записи
            7, пишем данные
            8, закрываем поток
         */

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.d(TAG, "SD not available: " + Environment.getExternalStorageState());
            return;
        }

        File sdPath = Environment.getExternalStorageDirectory();
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        sdPath.mkdirs();
        File sdFile = new File(sdPath, FILE_NAME_SD);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sdFile));
            bufferedWriter.write("File data on SD");
            bufferedWriter.close();

            Log.d(TAG, "writeToSD: file written on SD" + sdFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromSD() {
        /*
            1, проверяем доступна ли SD
            2, получаем путь к SD
            3, добавляем свой каталог к пути
            4, формируем объект File, который содержит путь к файлу
            5, открываем поток для чтения
            6, читаем содержимое
         */

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.d(TAG, "SD not available: " + Environment.getExternalStorageState());
            return;
        }

        File sdPath = Environment.getExternalStorageDirectory();
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        File sdFile = new File(sdPath, FILE_NAME_SD);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sdFile));
            String dataFileSD = "";
            while ((dataFileSD = bufferedReader.readLine()) != null) {
                Log.d(TAG, "readFromSD: " + dataFileSD);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ПРИМЕР ИЗ УРОКА БЕЗ СОЗДАНИЯ СВОЕЙ ДИРЕКТОРИИ НА SD

    //    void writeFileSD() {
//        Log.d(TAG, "write ");
//
//        // проверяем доступность SD
//        if (!Environment.getExternalStorageState().equals(
//                Environment.MEDIA_MOUNTED)) {
//            Log.d(TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
//            return;
//        }
//
//        // получаем путь к SD
//        File sdPath = Environment.getExternalStorageDirectory();
//        // добавляем свой каталог к пути
//        sdPath = new File(sdPath.getAbsolutePath());
//        // создаем каталог
//        sdPath.mkdirs();
//        // формируем объект File, который содержит путь к файлу
//        File sdFile = new File(sdPath, FILE_NAME_SD);
//
//        try {
//            // открываем поток для записи
//            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
//            // пишем данные
//            bw.write("Содержимое файла на SD");
//            // закрываем поток
//            bw.close();
//            Log.d(TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    void readFileSD() {
//        Log.d(TAG, "read ");
//
//        // проверяем доступность SD
//        if (!Environment.getExternalStorageState().equals(
//                Environment.MEDIA_MOUNTED)) {
//            Log.d(TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
//            return;
//        }
//
//        // получаем путь к SD
//        File sdPath = Environment.getExternalStorageDirectory();
//        // добавляем свой каталог к пути
//        sdPath = new File(sdPath.getAbsolutePath());
//        // формируем объект File, который содержит путь к файлу
//        File sdFile = new File(sdPath, FILE_NAME_SD);
//        try {
//            // открываем поток для чтения
//            BufferedReader br = new BufferedReader(new FileReader(sdFile));
//            String str = "";
//            // читаем содержимое
//            while ((str = br.readLine()) != null) {
//                Log.d(TAG, str);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
