package ru.mirea.reshetnikovdd.lesson2;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MethodName.printCurrentMethodName();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
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
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MethodName.printCurrentMethodName();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MethodName.printCurrentMethodName();
    }


}






