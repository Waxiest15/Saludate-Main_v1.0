package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Medicine_e extends AppCompat {

    public static final String EXTRA_MESSAGE_3 =
            "com.example.android.Intent.extra.MESSAGE";
    FirebaseAuth firebaseAuth;
    String M_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView temp = findViewById(R.id.txt_medicineHeader);
        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();


        RecyclerView recyclerView;
        ArrayList<Medicine_Object> list;
        ArrayList<String> listKey = new ArrayList<>();
        DatabaseReference databaseReference;
        MedicineAdapter medicineAdapter;

        Intent respond = getIntent();
        String id = respond.getStringExtra(PacienteInfo.EXTRA_MESSAGE_2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_e);

        recyclerView = findViewById((R.id.recycleMedicine));
        databaseReference = FirebaseDatabase.getInstance().getReference("Enfermeras").child(M_ID).child("patients").child(id).child("medice");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        Log.d("LIST", list.toString());
        Log.d("MEDICINE", databaseReference.toString());

        medicineAdapter = new MedicineAdapter(this, list);
        recyclerView.setAdapter(medicineAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Log.d("PADRE", dataSnapshot.getKey().toString());
                    //sendTo=dataSnapshot.getKey().toString();
                    Medicine_Object medicine = dataSnapshot.getValue(Medicine_Object.class);
                    list.add(medicine);
                    //listKey.add(sendTo);
                }
                medicineAdapter.setMedicineList(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button btn = findViewById(R.id.btn_addMedicine);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), MedicineRegister.class);
                individual.putExtra(EXTRA_MESSAGE_3, id);
                startActivity(individual);
            }
        });
    }

    private static final int PICK_PDF_FILE = 2;

    private void openFile(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");

        // Optionally, specify a URI for the file that should appear in the
        // system file picker when it loads.
        startActivityForResult(intent, PICK_PDF_FILE);
    }
}