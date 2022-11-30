package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saludate.ui.account.AccountFragment;

public class MedicineRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_register);
    }
    public void onClick(View view){
        Intent myIntent=new Intent(MedicineRegister.this, MainActivity.class); //CAMBIAR!!
        startActivity(myIntent);
    }
}