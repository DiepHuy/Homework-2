package com.huy.dialog_homework;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity implements ColorDialog.OnTransferTextListener {

    private AppCompatButton mBtnStart;
    private AppCompatButton mBtnEnd;
    private AppCompatButton mBtnCombine;
    private ImageView mImg;

    private int clStart = R.color.yellow, clEnd = R.color.yellow;

    //0 is start button, 1 is end button
    private int selectedButton = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = findViewById(R.id.btnStart);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButton = 0;
                ColorDialog dialog = new ColorDialog();
                dialog.show(getSupportFragmentManager(), ColorDialog.class.getSimpleName());
            }
        });

        mBtnEnd = findViewById(R.id.btnEnd);
        mBtnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButton = 1;
                ColorDialog dialog = new ColorDialog();
                dialog.show(getSupportFragmentManager(), ColorDialog.class.getSimpleName());
            }
        });

        mBtnCombine = findViewById(R.id.btnCombine);
        mImg = findViewById(R.id.img);
        mBtnCombine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GradientDrawable gd = new GradientDrawable(
                        GradientDrawable.Orientation.LEFT_RIGHT,
                        new int[]{getColor(clStart), getColor(clEnd)});
                gd.setCornerRadius(0f);

                mImg.setBackgroundDrawable(gd);
            }
        });

    }

    @Override
    public void transfer(Color color) {
        if (selectedButton == 0) {
            mBtnStart.setBackgroundResource(color.getResourceId());
            clStart = color.getResourceId();
        } else {
            mBtnEnd.setBackgroundResource(color.getResourceId());
            clEnd = color.getResourceId();
        }
    }
}
