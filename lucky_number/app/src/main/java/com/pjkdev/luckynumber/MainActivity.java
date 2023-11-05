package com.pjkdev.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nameField;
    TextView titleText;
    Button luckyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        titleText = findViewById(R.id.titleText);
        luckyBtn = findViewById(R.id.luckyBtn);

        luckyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = nameField.getText().toString();

                // Explicit Intent
                Intent intent = new Intent(getApplicationContext(), ShowLuckyNumber.class);

                // Passing the name to the ShowLuckyNumber activity
                intent.putExtra("name", inputName);

                startActivity(intent);
            }
        });
    }
}