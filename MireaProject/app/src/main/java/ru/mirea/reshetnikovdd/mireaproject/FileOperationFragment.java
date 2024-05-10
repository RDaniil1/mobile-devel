package ru.mirea.reshetnikovdd.mireaproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FileOperationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FileOperationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String FILENAME;
    private String TEXT;

    public FileOperationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FileOperationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FileOperationFragment newInstance(String param1, String param2) {
        FileOperationFragment fragment = new FileOperationFragment();
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
        return inflater.inflate(R.layout.fragment_file_operation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = getView().findViewById(R.id.archive);
        button.setOnClickListener(this::archive);
    }

    public void archive(View view) {
        EditText filename = getView().findViewById(R.id.filename);
        FILENAME = filename.getText().toString();

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, FILENAME + ".txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile());
            OutputStreamWriter output = new OutputStreamWriter(fileOutputStream);

            EditText quote = getView().findViewById(R.id.text);
            TEXT = quote.getText().toString();
            output.write(TEXT);

            output.close();
        } catch (IOException e) {
            Log.w("ExternalStorage", "Error writing " + file, e);
        }

        File zipPath = new File(path, FILENAME + ".zip");
        ZipFile zipFile = new ZipFile(zipPath);
        try {
            zipFile.addFile(file);
            zipFile.close();
        } catch (Exception e) {
            Log.w("ExternalStorage", e.getMessage(), e);
        }
    }
}