package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Singup extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btn = findViewById(R.id.button_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), MainActivity.class);
                startActivity(individual);
            }
        });
    }
    public void signtolog(View view){
        intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }






}