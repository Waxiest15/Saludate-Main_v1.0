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
    private String userID;
    FirebaseAuth firebaseAuth;
    private UserModel userModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        editTextName = findViewById(R.id.editTxt_personNameh);
        editTextPhone = findViewById(R.id.editTxt_Phoneh);
        editTextEmail = findViewById(R.id.editTxt_Dateh);
        btnSave = findViewById(R.id.btn_correct1h_f);
        loadingPB = findViewById(R.id.idPBLoading);
        userModel = getIntent().getParcelableExtra("Enfermeras");
        if (userModel!=null){
            editTextName.setText(userModel.getName());
            editTextPhone.setText(userModel.getPhone());
            editTextEmail.setText(userModel.getEmail());
            userID = firebaseAuth.getCurrentUser().getUid();
        }

        dbRef = firebaseDatabase.getReference("Enfermeras").child(userID);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String usern = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();

                Map<String, Object> map = new HashMap<>();
                map.put("name", usern);
                map.put("email", email);
                map.put("phone", phone);
                map.put("id", userID);

                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        dbRef.updateChildren(map);
                        Toast.makeText(EditUserProfile.this, "User Updated...",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditUserProfile.this, AccountFragment.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditUserProfile.this,"Error is"+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
