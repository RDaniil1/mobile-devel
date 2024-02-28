package ru.mirea.reshetnikovdd.lesson2;

import android.util.Log;

import androidx.constraintlayout.widget.Constraints;

public class MethodName {
    static public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }

    static public void printCurrentMethodName() {
        Log.i(Constraints.TAG, getCurrentMethodName());
    }
}
