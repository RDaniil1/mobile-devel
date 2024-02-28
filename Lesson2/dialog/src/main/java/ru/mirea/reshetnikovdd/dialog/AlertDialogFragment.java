package ru.mirea.reshetnikovdd.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class AlertDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Здравствуй МИРЭА!");
        builder.setMessage("Успех близок?");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setPositiveButton("Иду дальше", (dialog, which) -> {
            ((MainActivity) requireActivity()).onOkClicked();
            dialog.cancel();
        });
        builder.setNeutralButton("На паузе", (dialog, which) -> {
            ((MainActivity)requireActivity()).onNeutralClicked();
            dialog.cancel();
        });
        builder.setNegativeButton("Нет", (dialog, which) -> {
            ((MainActivity)requireActivity()).onCancelClicked();
            dialog.cancel();
        });

        return builder.create();
    }
}
