package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);

        Button buttonYellow = findViewById(R.id.buttonYellow);
        Button buttonBlue = findViewById(R.id.buttonBlue);
        Button buttonRed = findViewById(R.id.buttonRed);
        Button buttonGreen = findViewById(R.id.buttonGreen);

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            }
        });
    }
}