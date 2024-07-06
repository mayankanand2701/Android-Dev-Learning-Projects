package com.example.themechange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button light;
    private Button dark;
    private ConstraintLayout clayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        light=findViewById(R.id.btnlight);
        dark=findViewById(R.id.btndark);
        clayout=findViewById(R.id.clayout);
        light.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                //change to read mode
                clayout.setBackgroundResource(R.color.purple_200);
            }
        });
        dark.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                //change to dark mode
                clayout.setBackgroundResource(R.color.teal_700);
            }
        });

    }
}