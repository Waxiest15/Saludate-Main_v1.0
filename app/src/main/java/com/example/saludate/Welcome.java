package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Button loginbtn,signbtn;;
    Intent intent, intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginbtn= findViewById(R.id.login_ButtonM);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
    public void welcometosign(View view){
        intent2=new Intent(getApplicationContext(),Singup.class);
        startActivity(intent2);
    }
}