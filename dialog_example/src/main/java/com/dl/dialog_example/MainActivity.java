package com.dl.dialog_example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity implements CustomDialog.OnTransferTextListener {

    private AppCompatButton btnShowAlertDialog;
    private AppCompatButton btnShowDialogFragment;
    private AppCompatButton btnShowCustomDialog;

    private AppCompatTextView tvFromDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowAlertDialog = findViewById(R.id.btnShowAlertDialog);
        btnShowAlertDialog.setOnClickListener(view -> {
            showAlertDialog();
        });

        btnShowDialogFragment = findViewById(R.id.btnShowDialogFragment);
        btnShowDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ADialog dialog = new ADialog();
                dialog.show(getSupportFragmentManager(), ADialog.class.getSimpleName());
            }
        });

        btnShowCustomDialog = findViewById(R.id.btnShowCustomDialog);
        btnShowCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog dialog = CustomDialog.newInstance(tvFromDialog.getText().toString());
                dialog.show(getSupportFragmentManager(), CustomDialog.class.getSimpleName());
            }
        });

        tvFromDialog = findViewById(R.id.tvFromDialog);

    }

    private void showAlertDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Clicked positive button", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Clicked Negative button", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton(R.string.neutral_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Clicked Neutral button", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }


    @Override
    public void transfer(String text) {
        tvFromDialog.setText(text);
    }
}
