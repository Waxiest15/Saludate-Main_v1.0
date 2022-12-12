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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pacientes extends AppCompat {

    private String sendTo;
    FirebaseAuth firebaseAuth;
    String M_ID;
    public static final String EXTRA_MESSAGE =
            "com.example.android.Intent.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RecyclerView recyclerView;
        ArrayList<Paciente_Recycle> list;
        ArrayList<String> listKey = new ArrayList<>();
        DatabaseReference databaseReference;
        PatientAdapter patientAdapter;
        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes);

        recyclerView = findViewById((R.id.recycleV_patients));
        databaseReference = FirebaseDatabase.getInstance().getReference("Enfermeras").child(M_ID).child("patients");
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
                    Log.d("PADRE", dataSnapshot.getKey().toString());
                    sendTo=dataSnapshot.getKey().toString();
                    Paciente_Recycle paciente = dataSnapshot.getValue(Paciente_Recycle.class);
                    list.add(paciente);
                    listKey.add(sendTo);
                }
                patientAdapter.setPatientList(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        patientAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_addPatient;
                String id="1";
                String msg = listKey.get(recyclerView.getChildAdapterPosition(v)).toString();
                intent_addPatient = new Intent(v.getContext(), PacienteInfo.class);
                intent_addPatient.putExtra(EXTRA_MESSAGE, msg);
                startActivity(intent_addPatient);
                Toast.makeText(getApplicationContext(), "XD: ", Toast.LENGTH_SHORT).show();
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

        Button buttonPatient = findViewById(R.id.btn_toPatient_re);
        buttonPatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_addPatient;
                String id="1";
                intent_addPatient = new Intent(v.getContext(), PacienteInfo.class);
                intent_addPatient.putExtra(EXTRA_MESSAGE, id);
                startActivity(intent_addPatient);
            }
        });



    }
}