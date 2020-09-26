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

public class question2 extends AppCompatActivity implements View.OnClickListener {

    Button option1, option2, option3, option4;
    String question1, question2,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        option1 = findViewById(R.id.question2_option1);
        option2 = findViewById(R.id.question2_option2);
        option3 = findViewById(R.id.question2_option3);
        option4 = findViewById(R.id.question2_option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        question1 = getIntent().getStringExtra("question1");
        gender = getIntent().getStringExtra("gender");
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(question2.this,
                question3.class);

        switch (v.getId()) {
            case R.id.question2_option1 :
                question2 = "option1";
                option1.setBackgroundColor(Color.parseColor("#58F868"));
                break;
            case R.id.question2_option2 :
                question2 = "option2";
                option2.setBackgroundColor(Color.parseColor("#58F868"));
                break;
            case R.id.question2_option3 :
                question2 = "option3";
                option3.setBackgroundColor(Color.parseColor("#58F868"));
                break;
            case R.id.question2_option4 :
                question2 = "option4";
                option4.setBackgroundColor(Color.parseColor("#58F868"));
                break;
        }

        intent.putExtra("gender", gender);
        intent.putExtra("question1", question1);
        intent.putExtra("question2", question2);
        startActivity(intent);
        CustomIntent.customType(question2.this, "left-to-right");
        finish();
    }
}
