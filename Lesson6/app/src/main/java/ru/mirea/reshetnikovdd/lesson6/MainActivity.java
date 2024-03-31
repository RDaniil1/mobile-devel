package ru.mirea.reshetnikovdd.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "data";
    private EditText editText, editText2, editText3;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private String PREF_NAME = "GROUP";
    private String PREF_NAME2 = "NUMBER";
    private String PREF_NAME3 = "SERIAL";
    private String GROUP = "БИСО-03-19";
    private String NUMBER = "21";
    private String SERIAL = "Альф";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        editText3 = findViewById(R.id.editTextText3);

        editText.setText(GROUP);
        editText2.setText(NUMBER);
        editText3.setText(SERIAL);

        settings = getSharedPreferences(FILENAME, MODE_PRIVATE);
        String name = settings.getString(PREF_NAME,GROUP);
        String name2 = settings.getString(PREF_NAME2,NUMBER);
        String name3 = settings.getString(PREF_NAME3,SERIAL);

        editText.setText(name);
        editText2.setText(name2);
        editText3.setText(name3);
    }

    public void saveName(View view) {
        EditText nameBox1 = findViewById(R.id.editTextText);
        String name = nameBox1.getText().toString();
        EditText nameBox2 = findViewById(R.id.editTextText2);
        String name2 = nameBox2.getText().toString();
        EditText nameBox3 = findViewById(R.id.editTextText3);
        String name3 = nameBox3.getText().toString();

        editor = settings.edit();
        editor.putString(PREF_NAME, name);
        editor.putString(PREF_NAME2, name2);
        editor.putString(PREF_NAME3, name3);
        editor.apply();
    }

}