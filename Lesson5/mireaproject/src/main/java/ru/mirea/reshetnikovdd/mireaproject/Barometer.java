package ru.mirea.reshetnikovdd.mireaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ru.mirea.reshetnikovdd.mireaproject.databinding.BarometerBinding;

public class Barometer extends AppCompatActivity {

    private TextView textView;
    private SensorManager sensorManager;
    private Sensor sensorPressure;
    private BarometerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = BarometerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        textView = findViewById(R.id.textView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        SensorEventListener sensorEventListenerBarometer = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;

                String output = "";
                if (values[0] > 1022)
                {
                    output = "Высокое давление";
                }
                else if (values[0] < 1022 && values[0] > 1009)
                {
                    output = "Нормальное давление";
                }
                else if (values[0] < 1009)
                {
                    output = "Низкое давление";
                }
                textView.setText(output);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(sensorEventListenerBarometer, sensorPressure, SensorManager.SENSOR_DELAY_NORMAL);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Barometer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}