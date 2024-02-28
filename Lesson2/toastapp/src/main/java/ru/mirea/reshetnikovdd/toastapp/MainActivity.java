package ru.mirea.reshetnikovdd.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnCountClick(View view) {
        EditText editTextText = findViewById(R.id.editTextText);
        Integer messageLen = editTextText.length();
        String output = String.format("СТУДЕНТ № 21 ГРУППА БИСО-03-19 Количество символов %d", messageLen);
        Toast toast = Toast.makeText(this, output, Toast.LENGTH_LONG);
        toast.show();
    }
}