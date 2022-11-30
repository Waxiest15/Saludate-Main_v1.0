package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VitalSigns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs);
    }

    public void onClik(View view){
        Intent act = null;
        switch (view.getId()){
            case R.id.butt_sugarBlood_e:
                act = new Intent(VitalSigns.this, SugarBlood.class);
                break;
            case R.id.butt_temperature_e:
                act = new Intent(VitalSigns.this, Temperature.class);
                break;
            case R.id.butt_heartRate_e:
                act = new Intent(VitalSigns.this, HeartRate.class);
                break;
            case R.id.butt_bloodPreasure_e:
                act = new Intent(VitalSigns.this, BloodPreasure.class);
                break;
            case R.id.butt_breathingFrequency_e:
                act = new Intent(VitalSigns.this, BreathingFrecuency.class);
                break;
            case R.id.butt_oxygenation_e:
                act = new Intent(VitalSigns.this, Oxygenation.class);
                break;
            case R.id.butt_healtCondition_e:
                act = new Intent(VitalSigns.this, HeartRate.class);
                break;
        }
        startActivity(act);
    }
}