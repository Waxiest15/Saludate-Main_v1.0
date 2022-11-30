package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saludate.ui.account.AccountFragment;

public class Exit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
    }

    public void onClick(View view){
        Intent myIntent=null;
        switch (view.getId()){
            case R.id.btn_exith:
                myIntent=new Intent(Exit.this, MainActivity.class); //CAMBIAR MAIN A LOGIN
                break;
            case R.id.btn_cancelh:
                myIntent=new Intent(Exit.this, AccountFragment.class);
                break;
        }
        startActivity(myIntent);
    }
}