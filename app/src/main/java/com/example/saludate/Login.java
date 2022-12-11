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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText pass, email;
    Intent intent;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email= findViewById(R.id.email_LoginM);
        pass= findViewById(R.id.passwordLoginM);

        firebaseAuth = FirebaseAuth.getInstance();

        Button btn = findViewById(R.id.login_button_accessM);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mail, password;
                mail = email.getText().toString();
                password = pass.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent individual = new Intent(v.getContext(), MainActivity.class);
                            startActivity(individual);
                            email.setText("");
                            pass.setText("");
                        }else{
                            Toast.makeText(Login.this, "No se puede iniciar sesión",Toast.LENGTH_SHORT);
                        }
                    }
                });

            }
        });
    }
    public void LogtoSign(View view){
        intent=new Intent(getApplicationContext(),Singup.class);
        startActivity(intent);
    }
    public void LogtoPass(View view){
        intent=new Intent(getApplicationContext(),Forgot_password.class);
        startActivity(intent);
    }

}