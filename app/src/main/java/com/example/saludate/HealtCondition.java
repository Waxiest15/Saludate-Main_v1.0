package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HealtCondition extends AppCompat {

    EditText name, time, value, alarms;
    FirebaseAuth firebaseAuth;
    String M_ID;

    VitalSigns_Object newVital = new VitalSigns_Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healt_condition);

        Intent respond = getIntent();
        String id = respond.getStringExtra(PacienteInfo.EXTRA_MESSAGE_2);
        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();

        Toast.makeText(this, "<"+id+">", Toast.LENGTH_SHORT).show();

        time=findViewById(R.id.editTextTextPersonName);
        value=findViewById(R.id.ValueSet);
        alarms=findViewById(R.id.alarm);

        Button btnCreate = findViewById(R.id.btn_addMedicalTest_Register);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Asigan el nodo Employee para poner nodos dentro de el
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras/"+M_ID+"/patients/"+id+"/vital-signs/"+id+"/health_condition");
                try {
                    //condiciones para asegurarse que los campos requeridos tienen informacion
                    if (TextUtils.isEmpty(time.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Dosis", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(value.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Time", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(alarms.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Intevals", Toast.LENGTH_SHORT).show();
                    else {
                        newVital.setName(id);
                        newVital.setTime(time.getText().toString());
                        newVital.setValue(value.getText().toString());
                        newVital.setAlarms(alarms.getText().toString());

                        dbRef.child(newVital.getName()).setValue(newVital);

                        Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid contact Number", Toast.LENGTH_SHORT).show();
                }finally {
                    finish();
                }
            }
        });
    }
    public void onClick(View view){
        finish();
    }
}