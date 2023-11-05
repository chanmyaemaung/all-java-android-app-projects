package com.pjkdev.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView welcomeText, showConvertText;
    Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Welcome text
                welcomeText.setText("Welcome to kilo to pound converter app.");

                // Getting user input value
                String inputText = editText.getText().toString();

                // Convert to double
                Double kilos = Double.parseDouble(inputText);

                double pounds = convertToPound(kilos);

                // Show the result in pounds
                showConvertText.setText("" + pounds);
            }
        });
    }

    public double convertToPound(double kg) {
        // 1kg = 2.20462 pounds
        return kg * 2.20462;
    }
}