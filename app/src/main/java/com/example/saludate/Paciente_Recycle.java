package com.example.saludate;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Paciente_Recycle {
    private String name;

    public Paciente_Recycle() {

    }

    public Paciente_Recycle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
