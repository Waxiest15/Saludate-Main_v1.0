package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class PacienteInfo extends AppCompatActivity {

    TextView pName, pAge, pTemp, pPressure, pHC, pGlucose, pBed;
    DatabaseReference dRef;
    String nameAux, LNAux, LN2Aux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_info);

        pName=findViewById(R.id.txt_patient_name);
        pAge=findViewById(R.id.txt_patientAge);
        pTemp=findViewById(R.id.txt_patientTemp);
        pPressure=findViewById(R.id.txt_patientPressure);
        pHC=findViewById(R.id.txt_patientHC);
        pGlucose=findViewById(R.id.patient_Glucose);
        pBed=findViewById(R.id.txt_PatientBed);


        Button btn = findViewById(R.id.btn_toMedicine);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), Medicine_e.class);
                startActivity(individual);
            }
        });

        Button btn2 = findViewById(R.id.btn_toVitalSings);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), VitalSigns.class);
                startActivity(individual);
            }
        });

        Button btn3 = findViewById(R.id.btn_toNotes);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), Notes.class);
                startActivity(individual);
            }
        });

        Button btn4 = findViewById(R.id.btn_toMedicalTest);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), MedicalTest_e.class);
                startActivity(individual);
            }
        });

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child("enf_1").child("patients").child("0");
        Log.d("Conexion: ", readRef.toString());
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    //llenamos los valores de los campos en la interfaz con los valores retornados


                    nameAux=dataSnapshot.child("name").child("name").getValue().toString();
                    LNAux=dataSnapshot.child("name").child("last1").getValue().toString();
                    LN2Aux=dataSnapshot.child("name").child("last2").getValue().toString();

                    pName.setText(nameAux + " " + LNAux + " " + LN2Aux);

                    pAge.setText("Age\n29");
                    pBed.setText("Bed\n"+dataSnapshot.child("bed").getValue().toString());
                    pGlucose.setText("80");
                    pHC.setText("Health\nCondition\nOk")   ;
                } else {
                    Toast.makeText(getApplicationContext(), "no data to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}