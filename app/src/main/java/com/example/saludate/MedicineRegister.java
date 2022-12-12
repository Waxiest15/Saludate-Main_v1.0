package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.EditText;

import com.example.saludate.ui.account.AccountFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicineRegister extends AppCompatActivity {
    EditText name, dosis, via, hora, intervalos;

    Medicine_Object newMedicine = new Medicine_Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_register);

        Intent respond = getIntent();
        String id = respond.getStringExtra(Medicine_e.EXTRA_MESSAGE_3);

        Toast.makeText(this, "<"+id+">", Toast.LENGTH_SHORT).show();

        name=findViewById(R.id.editTxt_medicineNameh);
        dosis=findViewById(R.id.editTxt_dosageh);
        hora=findViewById(R.id.editTxt_timeh);
        intervalos=findViewById(R.id.editTxt_intervalsh);
        via=findViewById(R.id.editTxt_viah);

        ImageButton btnCreate = findViewById(R.id.btn_okh);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Asigan el nodo Employee para poner nodos dentro de el
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Enfermeras/enf_1/patients/"+id+"/medice");
                try {
                    //condiciones para asegurarse que los campos requeridos tienen informacion
                    if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Medicine Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(dosis.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Dosis", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(hora.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Time", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(intervalos.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Intevals", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(via.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter VIA", Toast.LENGTH_SHORT).show();
                    else {
                        newMedicine.setName(name.getText().toString());
                        newMedicine.setDosis(dosis.getText().toString());
                        newMedicine.setIntervals(intervalos.getText().toString());
                        newMedicine.setTime(hora.getText().toString());
                        newMedicine.setVia(via.getText().toString());

                        dbRef.child(newMedicine.getName()).setValue(newMedicine);

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




}