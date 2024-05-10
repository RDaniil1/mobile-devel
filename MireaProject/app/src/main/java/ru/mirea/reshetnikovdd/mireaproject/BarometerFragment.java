package ru.mirea.reshetnikovdd.mireaproject;

import static android.content.Context.SENSOR_SERVICE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BarometerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BarometerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView textView;
    private SensorManager sensorManager;
    private Sensor sensorPressure;

    public BarometerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BarometerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BarometerFragment newInstance(String param1, String param2) {
        BarometerFragment fragment = new BarometerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_barometer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = getView().findViewById(R.id.barometerRes);

        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
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

    }
}