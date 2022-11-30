package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManualRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_register);

        Button btn = findViewById(R.id.btn_addMedicalTest_Register);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), AddTest_e.class);
                startActivity(individual);
            }
        });

        Button btn2 = findViewById(R.id.btn_RegisterDone);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), PacienteInfo.class);
                startActivity(individual);
            }
        });


    }
}