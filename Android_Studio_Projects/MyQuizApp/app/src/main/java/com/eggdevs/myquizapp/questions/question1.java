package com.eggdevs.myquizapp.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.eggdevs.myquizapp.R;

import maes.tech.intentanim.CustomIntent;

public class question1 extends AppCompatActivity implements View.OnClickListener {

    Button option1, option2, option3, option4;
    String question1, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        option1 = findViewById(R.id.question1_option1);
        option2 = findViewById(R.id.question1_option2);
        option3 = findViewById(R.id.question1_option3);
        option4 = findViewById(R.id.question1_option4);

        gender = getIntent().getStringExtra("gender");

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(question1.this,
                question2.class);

        switch (v.getId()) {
            case R.id.question1_option1 :
                question1 = "option1";
                option1.setBackgroundColor(Color.parseColor("#58F868"));
                break;
            case R.id.question1_option2 :
                question1 = "option2";
                option2.setBackgroundColor(Color.parseColor("#58F868"));
                break;
            case R.id.question1_option3 :
                question1 = "option3";
                option3.setBackgroundColor(Color.parseColor("#58F868"));
                break;
            case R.id.question1_option4 :
                question1 = "option4";
                option4.setBackgroundColor(Color.parseColor("#58F868"));
                break;
        }

        intent.putExtra("question1", question1);
        intent.putExtra("gender", gender);
        startActivity(intent);
        CustomIntent.customType(question1.this, "left-to-right");
        finish();
    }
}
