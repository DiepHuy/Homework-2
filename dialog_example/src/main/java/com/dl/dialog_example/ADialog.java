package com.dl.dialog_example;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * Created by DucLe on 18/12/2022.
 */
public class ADialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("Dialog Fragment")
                .setMessage(R.string.alert_message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Clicked positive button", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Clicked Negative button", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton(R.string.neutral_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Clicked Neutral button", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        return dialog;
    }
}
