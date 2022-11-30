package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saludate.ui.account.AccountFragment;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }
    public void onClick(View view){
        Intent myIntent=new Intent(Notes.this, MainActivity.class); //CAMBIAR!!
        startActivity(myIntent);
    }
}