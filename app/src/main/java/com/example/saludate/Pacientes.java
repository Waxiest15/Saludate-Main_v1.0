package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Pacientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes);

<<<<<<< Updated upstream
=======
        recyclerView = findViewById((R.id.recycleV_patients));
        databaseReference = FirebaseDatabase.getInstance().getReference("Enfermeras");
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



>>>>>>> Stashed changes
        FloatingActionButton button = findViewById(R.id.fab_patientAdd_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_addPatient;
                intent_addPatient = new Intent(v.getContext(), RegisterType.class);
                startActivity(intent_addPatient);
            }
        });

        Button patient_1 = findViewById(R.id.btn_patient_001_fragment);
        patient_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), PacienteInfo.class);
                startActivity(individual);
            }
        });

    }
}