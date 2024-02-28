package ru.mirea.reshetnikovdd.multiactivity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MethodName.printCurrentMethodName();
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editTextText = findViewById(R.id.editTextText);
        intent.putExtra("key", editTextText.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
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