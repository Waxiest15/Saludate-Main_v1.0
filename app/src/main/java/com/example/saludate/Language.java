package com.example.saludate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class Language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        ImageButton en = findViewById(R.id.btn_selectEnglishh);
        ImageButton spa = findViewById(R.id.btn_selectSpanishh);
        ImageButton fr = findViewById(R.id.btn_selectFrenchh);
        ImageButton kr = findViewById(R.id.btn_selectKoreanh);
        LanguageManager lang = new LanguageManager(this);

        en.setOnClickListener(view -> {
            lang.updateResource("en");
            recreate();
        });
        spa.setOnClickListener(view -> {
            lang.updateResource("es");
            recreate();
        });
        fr.setOnClickListener(view -> {
            lang.updateResource("fr");
            recreate();
        });
        kr.setOnClickListener(view -> {
            lang.updateResource("ko");
            recreate();
        });
    }
}