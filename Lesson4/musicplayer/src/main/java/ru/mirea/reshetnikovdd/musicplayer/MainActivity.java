package ru.mirea.reshetnikovdd.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ru.mirea.reshetnikovdd.musicplayer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        player = MediaPlayer.create(this, R.raw.ringtone);
    }

    public void onPlay(View v)
    {
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.class.getSimpleName(),"play");
                player.start();
            }
        });
    }

    public void onPause(View v)
    {
        binding.pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.class.getSimpleName(),"pause");
                player.pause();
            }
        });
    }
}