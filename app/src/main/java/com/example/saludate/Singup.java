package com.example.saludate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Singup extends AppCompatActivity {
    Intent intent;
    EditText nom, email, pass;
    Button btn;
    DatabaseReference dbRef;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.EmailSignUpM);
        pass = findViewById(R.id.PasswordSignupM);
        nom = findViewById(R.id.NameSignUpM);
        dbRef = FirebaseDatabase.getInstance().getReference();

        btn = findViewById(R.id.button_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mail = email.getText().toString();
                String password = pass.getText().toString();
                String name = nom.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String id = firebaseAuth.getCurrentUser().getUid();
                            Map<String, Object> map= new HashMap<>();
                            map.put("name", name );
                            map.put("email",mail);
                            map.put("password",password);
                            map.put("Cel", "");
                            map.put("id", id);
                            map.put("Turno","");
                            dbRef.child("Enfermeras").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {
                                 if (task2.isSuccessful()){
                                     Toast.makeText(Singup.this, "Usuario creado con Exito",Toast.LENGTH_SHORT);
                                     finish();
                                 }
                                }
                            });
                        }else{
                            Toast.makeText(Singup.this, "Usuario no creado",Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
        });
    }
    public void signtolog(View view){
        intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }







}