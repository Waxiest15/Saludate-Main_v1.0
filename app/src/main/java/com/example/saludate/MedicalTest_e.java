package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedicalTest_e extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_test_e);

        Button btn = findViewById(R.id.btn_addMedicine);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), AddTest_e.class);
                startActivity(individual);
            }
        });
    }

    public void next_e1(){
        Intent act = new Intent(MedicalTest_e.this, AddTest_e.class);
        startActivity(act);
    }
}