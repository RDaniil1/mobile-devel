package ru.mirea.reshetnikovdd.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        String string = intent.getStringExtra("message");

        TextView textView = findViewById(R.id.textView);
        textView.setText(string);
    }
}