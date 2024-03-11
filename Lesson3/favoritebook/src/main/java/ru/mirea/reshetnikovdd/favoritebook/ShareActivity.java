package ru.mirea.reshetnikovdd.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textView2);
            String university = extras.getString(MainActivity.KEY);
            ageView.setText("Моя любимая книга: " + university);
        }
    }

    public void onClickSendBtn(View view) {
        EditText editText = findViewById(R.id.editTextText);
        String string = editText.getText().toString();

        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, string);
        setResult(Activity.RESULT_OK, data);
        finish();

    }
}