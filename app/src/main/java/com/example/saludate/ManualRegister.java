package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManualRegister extends AppCompat {
    EditText name, gender, age, birthday, status, date, checkin, bed, days, blood, inor, recordnum, dig, condition;
    FirebaseAuth firebaseAuth;
    String M_ID;

    RegisterUser_Object registerUser = new RegisterUser_Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_register);

        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();

        name=findViewById(R.id.editTxt_Name);
        gender=findViewById(R.id.editTxt_Gender);
        age=findViewById(R.id.editTxt_age);
        birthday=findViewById(R.id.editTxt_BirthDate);
        status=findViewById(R.id.editTxt_maritalState);
        date=findViewById(R.id.editTxt_Date);
        checkin=findViewById(R.id.editTxt_checkInCome);
        bed=findViewById(R.id.editTxt_Bed);
        days=findViewById(R.id.editTxt_daysOfState);
        blood=findViewById(R.id.editTxt_bloodType);
        inor=findViewById(R.id.editTxt_income);
        recordnum=findViewById(R.id.editTxt_medicalRecordNumber);
        dig=findViewById(R.id.editTxt_diagnostic);
        condition=findViewById(R.id.editTxt_patientStatus);


        Button btnCreate = findViewById(R.id.btn_RegisterDone);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Asigan el nodo Employee para poner nodos dentro de el
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras/"+M_ID+"/patients");
                try {
                    //condiciones para asegurarse que los campos requeridos tienen informacion
                    if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Medicine Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(gender.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Dosis", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(age.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Time", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(birthday.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Intevals", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(status.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(date.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(checkin.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(bed.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(days.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(blood.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(inor.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(recordnum.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(dig.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(condition.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else {
                        registerUser.setName(name.getText().toString());
                        registerUser.setGender(gender.getText().toString());
                        registerUser.setAge(age.getText().toString());
                        registerUser.setBirthday(birthday.getText().toString());
                        registerUser.setStatus(status.getText().toString());
                        registerUser.setDate(date.getText().toString());
                        registerUser.setCheckin(checkin.getText().toString());
                        registerUser.setBed(bed.getText().toString());
                        registerUser.setDays(days.getText().toString());
                        registerUser.setBlood(blood.getText().toString());
                        registerUser.setInor(inor.getText().toString());
                        registerUser.setInor(recordnum.getText().toString());
                        registerUser.setDig(dig.getText().toString());
                        registerUser.setCondition(condition.getText().toString());

                        dbRef.child(registerUser.getName()).setValue(registerUser);

                        Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid contact Number", Toast.LENGTH_SHORT).show();
                }finally {
                    finish();
                }
            }
        });
    }
    public void onClick(View view){
        finish();
    }
}