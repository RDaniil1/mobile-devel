package ru.mirea.reshetnikovdd.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
//import android.widget.TextView;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isRadioBtnOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void changeView() {
        TextView textView = findViewById(R.id.tvOut);
        textView.setText("Мой номер по списку № 21");
    }

    private void makeToastText() {
        Toast.makeText(this, "Мой номер по списку № 21", Toast.LENGTH_SHORT).show();
    }

    private void changeRadioBtn(){
        isRadioBtnOn = !isRadioBtnOn;
        RadioButton radioButton = findViewById(R.id.radioButton);
        radioButton.setChecked(isRadioBtnOn);
    }

    public void onBtnItIsNotMeClick(View view) {
        changeView();
        makeToastText();
        changeRadioBtn();
    }

    public void onBtnWhoAmIClick(View view) {
        changeView();
        makeToastText();
        changeRadioBtn();
    }
}