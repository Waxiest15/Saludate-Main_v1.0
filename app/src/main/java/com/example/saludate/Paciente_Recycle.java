package com.example.saludate;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Paciente_Recycle {



    private String cel;
    private String name, last, last2, age, bed;

    


    public Paciente_Recycle() {

    }

    public Paciente_Recycle(String cel) {
        this.cel = cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCel() {
        return cel;
    }
}
