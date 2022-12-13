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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MedicalTest_e extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RecyclerView recyclerView;
        ArrayList<MedicalTest_Object> list;
        ArrayList<String> listKey = new ArrayList<>();
        DatabaseReference databaseReference;
        MedicalTest_Adapter medicalTest_adapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_test_e);

        recyclerView = findViewById((R.id.recycleview_medicalTest));
        databaseReference = FirebaseDatabase.getInstance().getReference("Enfermeras/enf_1/patients/0/medical-test");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        Log.d("LIST", list.toString());
        Log.d("REFERENCE", databaseReference.toString());

        medicalTest_adapter = new MedicalTest_Adapter(this, list);
        recyclerView.setAdapter(medicalTest_adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Log.d("PADRE", dataSnapshot.getKey().toString());
                    //sendTo=dataSnapshot.getKey().toString();
                    MedicalTest_Object test = dataSnapshot.getValue(MedicalTest_Object.class);
                    list.add(test);
                    //listKey.add(sendTo);
                }
                medicalTest_adapter.setMedicicalTestList(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button btn = findViewById(R.id.btn_addMedicine);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), AddTest_e.class);
                startActivity(individual);
            }
        });
    }

    public void next_e1(){
        Intent act = new Intent(MedicalTest_e.this, AddTest_e.class);
        startActivity(act);
    }

    public void onClick(View view){
        finish();
    }
}