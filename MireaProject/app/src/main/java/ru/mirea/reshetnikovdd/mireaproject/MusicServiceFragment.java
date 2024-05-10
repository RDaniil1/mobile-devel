package ru.mirea.reshetnikovdd.mireaproject;

import static android.Manifest.permission.FOREGROUND_SERVICE;
import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textview.MaterialTextView;

import ru.mirea.reshetnikovdd.mireaproject.databinding.ActivityMainBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicServiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int PermissionCode = 200;
    ActivityMainBinding binding;

    public MusicServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicServiceFragment newInstance(String param1, String param2) {
        MusicServiceFragment fragment = new MusicServiceFragment();
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

        return inflater.inflate(R.layout.fragment_music_service, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (ContextCompat.checkSelfPermission(getActivity(), POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.d(MainActivity.class.getSimpleName().toString(), "Разрешения получены");
        } else {
            Log.d(MainActivity.class.getSimpleName().toString(), "Нет разрешений!");
            ActivityCompat.requestPermissions(getActivity(), new String[]{POST_NOTIFICATIONS, FOREGROUND_SERVICE}, PermissionCode);
        }

        Button start = getView().findViewById(R.id.start);
        start.setOnClickListener(this::start);

        Button pause = getView().findViewById(R.id.pause);
        pause.setOnClickListener(this::pause);
    }

    public void start(View view) {
        Intent serviceIntent = new Intent(getActivity(), MyService.class);
        ContextCompat.startForegroundService(getActivity(), serviceIntent);
    }

    public void pause(View view) {
        getActivity().stopService(new Intent(getActivity(), MyService.class));
    }


}