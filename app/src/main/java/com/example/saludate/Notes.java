package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saludate.ui.account.AccountFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Notes extends AppCompatActivity {

    EditText notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        notes=findViewById(R.id.editTxt_notesh);

        Intent respond = getIntent();
        String id = respond.getStringExtra(PacienteInfo.EXTRA_MESSAGE_2);

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child("enf_1").child("patients").child(id);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    //llenamos los valores de los campos en la interfaz con los valores retornados
                    notes.setText(dataSnapshot.child("Notas").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button btnUpdate = findViewById(R.id.btn_updateNotes);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child("enf_1").child("patients");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange (@NonNull DataSnapshot dataSnapshot){
                        if (dataSnapshot.hasChild(id)) {

                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child("enf_1").child("patients").child(id).child("Notas");
                            dbRef.setValue(notes.getText().toString());

                            Toast.makeText(getApplicationContext(), "Data updated", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "no data to display", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });//no tocar
            }
        });




    }
    public void onClick(View view){
        finish();
    }
}