package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forgot_password extends AppCompatActivity {
    Intent intent, intent2;
    Button codebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        codebtn= findViewById(R.id.Sendocodebtn);
        codebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2=new Intent(getApplicationContext(),OTP_Verification.class);
                startActivity(intent2);
            }
        });
    }

    public void forgortolog(View view){
        intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }

}