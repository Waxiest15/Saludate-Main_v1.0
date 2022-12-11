package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.saludate.ui.account.AccountFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MedicineRegister extends AppCompat {

    private EditText medicineName, dosage, timee, intervals, viaa;
    private ImageButton saveBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String M_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_register);
        firebaseAuth = FirebaseAuth.getInstance();
        medicineName = findViewById(R.id.editTxt_medicineNameh);
        dosage = findViewById(R.id.editTxt_dosageh);
        timee = findViewById(R.id.editTxt_timeh);
        intervals = findViewById(R.id.editTxt_intervalsh);
        viaa = findViewById(R.id.editTxt_viah);
        saveBtn = findViewById(R.id.btn_okh);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Enfermeras");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String name = medicineName.getText().toString();
                String dosis = dosage.getText().toString();
                String time = timee.getText().toString();
                String interv = intervals.getText().toString();
                String via = viaa.getText().toString();
                M_ID = firebaseAuth.getCurrentUser().getUid();

                MedicineRegisterModel medicineRegisterModel = new MedicineRegisterModel(M_ID,dosis,name,time,via,interv);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        databaseReference.child(M_ID).child("patients").child("medice").setValue(medicineRegisterModel);
                        Toast.makeText(MedicineRegister.this, "Medicine Added...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MedicineRegister.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MedicineRegister.this, "Error is"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}