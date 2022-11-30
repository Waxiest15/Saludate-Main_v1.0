package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PacienteInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_info);

        Button btn = findViewById(R.id.btn_toMedicine);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), Medicine_e.class);
                startActivity(individual);
            }
        });

        Button btn2 = findViewById(R.id.btn_toVitalSings);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), VitalSigns.class);
                startActivity(individual);
            }
        });

        Button btn3 = findViewById(R.id.btn_toNotes);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), Notes.class);
                startActivity(individual);
            }
        });

        Button btn4 = findViewById(R.id.btn_toMedicalTest);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), MedicalTest_e.class);
                startActivity(individual);
            }
        });


    }
}