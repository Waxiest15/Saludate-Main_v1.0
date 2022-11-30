package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordChanged extends AppCompatActivity {
    Intent intent;
    Button backlgn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_changed);
        backlgn= findViewById(R.id.back_to_LoginBtnM);
        backlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}