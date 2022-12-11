package com.example.saludate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.saludate.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompat {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private String sendTo;
    public static final String EXTRA_MESSAGE =
            "com.example.android.Intent.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView;
        ArrayList<Paciente_Recycle> list;
        ArrayList<String> listKey = new ArrayList<>();
        DatabaseReference databaseReference;
        PatientAdapter patientAdapter;

        

        recyclerView = findViewById((R.id.recycleV_patients));
        databaseReference = FirebaseDatabase.getInstance().getReference("Enfermeras").child("enf_1").child("patients");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        Log.d("LIST", list.toString());
        Log.d("REFERENCE", databaseReference.toString());

        patientAdapter = new PatientAdapter(this, list);
        recyclerView.setAdapter(patientAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Log.d("PADRE", dataSnapshot.getKey().toString());
                    sendTo=dataSnapshot.getKey().toString();
                    Paciente_Recycle paciente = dataSnapshot.getValue(Paciente_Recycle.class);
                    list.add(paciente);
                    listKey.add(sendTo);
                }
                patientAdapter.setPatientList(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        patientAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_addPatient;
                String id="1";
                String msg = listKey.get(recyclerView.getChildAdapterPosition(v)).toString();
                intent_addPatient = new Intent(v.getContext(), PacienteInfo.class);
                intent_addPatient.putExtra(EXTRA_MESSAGE, msg);
                startActivity(intent_addPatient);
                Toast.makeText(getApplicationContext(), "XD: ", Toast.LENGTH_SHORT).show();
            }
        });

        //setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.accountFragment, R.id.nav_gallery,
                R.id.nav_slideshow, R.id.languageFragment2, R.id.priSecFragment2)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        

        FloatingActionButton fab = findViewById(R.id.fab_patientAdd_fragment);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent individual = new Intent(v.getContext(), RegisterType.class);
                startActivity(individual);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}