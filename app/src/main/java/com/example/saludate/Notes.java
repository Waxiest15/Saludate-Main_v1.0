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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Notes extends AppCompat {
    private EditText notes;
    private ImageButton saveBtn;
    private ProgressBar loadingPB;
    FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String M_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notes = findViewById(R.id.editTxt_notesh);
        saveBtn = findViewById(R.id.btn_correcth);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Enfermeras");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String note = notes.getText().toString();
                M_ID = firebaseAuth.getCurrentUser().getUid();;

                NotesModel notesModel = new NotesModel(note);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        databaseReference.child(M_ID).child("patients").child("Notas").setValue(notesModel);
                        Toast.makeText(Notes.this, "Note Added...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Notes.this, PacienteInfo.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Notes.this, "Error is"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void onClick(View view){

    }
}