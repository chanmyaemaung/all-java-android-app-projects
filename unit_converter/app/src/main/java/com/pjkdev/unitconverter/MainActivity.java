package com.pjkdev.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView welcomeText, showConvertText;
    Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Select all corresponding variables
        welcomeText = findViewById(R.id.welcomeText);
        editText = findViewById(R.id.editText);
        showConvertText = findViewById(R.id.showConvertText);
        convertBtn = findViewById(R.id.convertBtn);

        // Welcome text
        welcomeText.setText("Welcome to my kilo to pound converter app.");

        // Default EditText value
        editText.setText("1");

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Getting user input value
                String inputText = editText.getText().toString();

                // Convert to double
                Double kilos = Double.parseDouble(inputText);

                // Convert to pounds
                double pounds = convertToPound(kilos);

                // Show the result in pounds
                showConvertText.setText("" + pounds + "lb");

                // Clear the input
                editText.setText("1");

                // Show toast message with result
                Toast.makeText(MainActivity.this, "Converted to pounds: " + pounds + "lb", Toast.LENGTH_LONG).show();
            }
        });
    }

    public double convertToPound(double kg) {
        // 1kg = 2.20462 pounds
        return kg * 2.20462;
    }
}