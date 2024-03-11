package ru.mirea.reshetnikovdd.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        long date = System.currentTimeMillis();
        String dateTemplate = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(dateTemplate);
        String dateString = sdf.format(new Date(date));

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ СОСТАВЛЯЕТ 441, а текущее время " + dateString);

        startActivity(intent);
    }
}