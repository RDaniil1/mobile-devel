package ru.mirea.reshetnikovdd.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView fioView = findViewById(R.id.fioView);
        String transferedData = (String) getIntent().getSerializableExtra("key");
        fioView.setText(transferedData);
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MethodName.printCurrentMethodName();
    }
}