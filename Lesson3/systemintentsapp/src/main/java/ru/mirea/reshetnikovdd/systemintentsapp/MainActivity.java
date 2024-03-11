package ru.mirea.reshetnikovdd.systemintentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void intentActivity(String intentAction, String uriString) {
        Intent intent = new Intent(intentAction);
        intent.setData(Uri.parse(uriString));
        startActivity(intent);
    }

    public void onClickCall(View view) {
        intentActivity(Intent.ACTION_DIAL, "tel:89811112233");
    }

    public void onClickOpenBrowser(View view) {
        intentActivity(Intent.ACTION_VIEW, "http://developer.android.com");
    }

    public void onClickOpenMaps(View view) {
        intentActivity(Intent.ACTION_VIEW, "geo:55.749479,37.613944");
    }
}