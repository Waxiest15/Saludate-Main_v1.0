package com.example.saludate;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Paciente_Recycle {
    private String name, age, bed;

    public Paciente_Recycle() {

    }

    public Paciente_Recycle(String name, String age, String bed) {
        this.name = name;
        this.age = age;
        this.bed = bed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
