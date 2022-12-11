package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pacientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RecyclerView recyclerView;
        ArrayList<Paciente_Recycle> list;
        DatabaseReference databaseReference;
        PatientAdapter patientAdapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes);

        recyclerView = findViewById((R.id.recycleV_patients));
        databaseReference = FirebaseDatabase.getInstance().getReference("Enfermeras").child("enf_1").child("patients");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        Log.d("LIST", list.toString());
        Log.d("REFERENCE", databaseReference.toString());

        patientAdapter = new PatientAdapter(this, list);
        recyclerView.setAdapter(patientAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    //Log.d("SNAP", snapshot.getValue((Paci)));
                    Paciente_Recycle paciente = dataSnapshot.getValue(Paciente_Recycle.class);
                    list.add(paciente);
                }
                patientAdapter.setPatientList(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        FloatingActionButton button = findViewById(R.id.fab_patientAdd_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_addPatient;
                intent_addPatient = new Intent(v.getContext(), RegisterType.class);
                startActivity(intent_addPatient);
            }
        });



    }
}