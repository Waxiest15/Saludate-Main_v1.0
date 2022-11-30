package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddTest_e extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test_e);
    }

    public void addTest(View view){
        Intent act = new Intent(AddTest_e.this, MedicalTest_e.class);
        startActivity(act);
    }
}