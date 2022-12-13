package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTest_e extends AppCompat {
    EditText done, date;
    String name;
    FirebaseAuth firebaseAuth;
    String M_ID;

    AddTest_Object newTest = new AddTest_Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test_e);

        Intent respond = getIntent();
        String id = respond.getStringExtra(Medicine_e.EXTRA_MESSAGE_3);

        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();

        Toast.makeText(this, "<"+id+">", Toast.LENGTH_SHORT).show();

        done=findViewById(R.id.editTextTextPersonName);
        date=findViewById(R.id.editTextTextPersonName1_e);


        ImageButton btnCreate = findViewById(R.id.next);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Asigan el nodo Employee para poner nodos dentro de el
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras/"+M_ID+"/patients/"+id+"/medical-test");
                try {
                    //condiciones para asegurarse que los campos requeridos tienen informacion
                    if (TextUtils.isEmpty(done.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Medicine Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(date.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Dosis", Toast.LENGTH_SHORT).show();
                    else {
                        newTest.setName(id);
                        newTest.setDone(done.getText().toString());
                        newTest.setDate(date.getText().toString());

                        dbRef.child(newTest.getName()).setValue(newTest);

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