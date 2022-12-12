package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.saludate.databinding.FragmentAccountBinding;
import com.example.saludate.ui.account.AccountFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditUserProfile extends AppCompat {

    private EditText editTextId, editTextName, editTextPhone, editTextEmail;
    private ImageButton btnSave;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dbRef;
    private String M_ID;
    FirebaseAuth firebaseAuth;
    EditUser_Object userModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        editTextName=findViewById(R.id.editTxt_personNameh);
        editTextPhone=findViewById(R.id.editTxt_Phoneh);
        editTextEmail=findViewById(R.id.editTxt_Dateh);

        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child(M_ID);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    //llenamos los valores de los campos en la interfaz con los valores retornados
                    editTextName.setText(dataSnapshot.child("name").getValue().toString());
                    editTextPhone.setText(dataSnapshot.child("Cel").getValue().toString());
                    editTextEmail.setText(dataSnapshot.child("email").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ImageButton btn_correct1h_f = findViewById(R.id.btn_correct1h_f);
        btn_correct1h_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child(M_ID);
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange (@NonNull DataSnapshot dataSnapshot){
                        if (dataSnapshot.hasChild(M_ID)) {
                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras").child(M_ID);
                            userModel.setName(editTextName.getText().toString());
                            userModel.setPhone(editTextPhone.getText().toString());
                            userModel.setEmail(editTextEmail.getText().toString());

                            dbRef.child(userModel.getName()).setValue(userModel);
                            Toast.makeText(getApplicationContext(), "Data updated", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "no data to display", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
    public void onClick(View view){
        finish();
    }
}