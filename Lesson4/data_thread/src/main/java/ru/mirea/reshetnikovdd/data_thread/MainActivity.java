package ru.mirea.reshetnikovdd.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ru.mirea.reshetnikovdd.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        text = findViewById(R.id.textView);

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.textView.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.textView.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.textView.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.textView.postDelayed(runn3, 2000);
                    binding.textView.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        text.setText("Последовательность запуска: runOnUiThread, post, postDelayed " +
                "runOnUiThread - запуск action в UI-потоке. " +
                "post - добавление action в очередь сооющений. " +
                "postDelayed - добавление action в очередь сообщений, установка задержки на запуск action. " +
                "android:maxLines='10' - установка огрничения textView на 10 строк. " +
                "android:lines='10' - размещение всего текста в 10 строках");
    }
}