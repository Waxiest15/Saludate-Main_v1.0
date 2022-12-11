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

public class PacienteInfo extends AppCompat {

    TextView pName, pAge, pTemp, pPressure, pHC, pGlucose, pBed;
    DatabaseReference dRef;
    String nameAux, LNAux, LN2Aux;

    private String sendTo;
    public static final String EXTRA_MESSAGE_2 =
            "com.example.android.Intent.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_info);

        Intent respond = getIntent();
        String id = respond.getStringExtra(Pacientes.EXTRA_MESSAGE);



        TextView temp = findViewById(R.id.txt_patient_name);

        temp.setText(id);

        pName=findViewById(R.id.txt_patient_name);
        pAge=findViewById(R.id.textView19);
        pTemp=findViewById(R.id.textView24);
        pPressure=findViewById(R.id.textView20);
        pHC=findViewById(R.id.textView25);
        pGlucose=findViewById(R.id.textView27);
        pBed=findViewById(R.id.textView26);


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
                individual.putExtra(EXTRA_MESSAGE_2, id);
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

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child("enf_1").child("patients").child(id);
        Log.d("Conexion: ", readRef.toString());
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    //llenamos los valores de los campos en la interfaz con los valores retornados


                    pName.setText(dataSnapshot.child("name").getValue().toString());

                    pAge.setText(dataSnapshot.child("age").getValue().toString()+"\nAge");
                    pBed.setText(dataSnapshot.child("bed").getValue().toString()+"\nBed");
                    pGlucose.setText(dataSnapshot.child("vital-signs").child("0").child("sugar_b").child("0").child("value").getValue().toString()+"\nGlucose");
                    pTemp.setText(dataSnapshot.child("vital-signs").child("0").child("temperature").child("0").child("value").getValue().toString()+"°\nGlucose");
                    pPressure.setText(dataSnapshot.child("vital-signs").child("0").child("blood_presure").child("0").child("value").getValue().toString()+"\nPressure");
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