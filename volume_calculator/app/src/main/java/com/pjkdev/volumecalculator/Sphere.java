package com.pjkdev.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sphere extends AppCompatActivity {

    EditText sphereRadius;
    TextView sphereResult;
    Button calSphereBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphereRadius = findViewById(R.id.sphereRadius);
        sphereResult = findViewById(R.id.sphereResult);
        calSphereBtn = findViewById(R.id.calSphereBtn);

        calSphereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = sphereRadius.getText().toString();
                int r = Integer.parseInt(radius);

                // Volume: V = (4/3) * pi * r^3
                double volume = 4 / 3 * 3.14159 * r * r * r;

                sphereResult.setText("V = " + volume + " m^3");
            }
        });
    }
}