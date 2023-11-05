package com.pjkdev.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ShowLuckyNumber extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lucky_number);

        TextView luckyNumber = findViewById(R.id.luckyNumber);
        Button shareLuckyBtn = findViewById(R.id.shareLuckyBtn);

        // Receiving the name from the MainActivity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        // Generating random numbers
        int random_number = generateRandomNumber();

        // Setting the text of the lucky number
        luckyNumber.setText("" + random_number);

        shareLuckyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_number);
            }
        });
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int limit_max_number = 1000;

        int generated_number = random.nextInt(limit_max_number);

        return generated_number;
    }

    public void shareData(String userName, int luckyNumber) {
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // Additional information
        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky number today!");
        i.putExtra(Intent.EXTRA_TEXT, userName + " lucky number is: " + luckyNumber);

        startActivity(Intent.createChooser(i, "Share via"));
    }
}