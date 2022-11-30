package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OTP_Verification extends AppCompatActivity {
    Intent intent;
    Button OTPbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        OTPbtn= findViewById(R.id.ResetPassBtnM);
        OTPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),PasswordChanged.class);
                startActivity(intent);
            }
        });
    }
}