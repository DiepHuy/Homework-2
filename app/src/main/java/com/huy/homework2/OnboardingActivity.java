package com.huy.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSignup = findViewById(R.id.bai1);
        btnSignup.setOnClickListener(view -> {
            Toast.makeText(OnboardingActivity.this, "Bài 1", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(OnboardingActivity.this, Bai1Activity.class);
            startActivity(intent);
        });
    }
}
