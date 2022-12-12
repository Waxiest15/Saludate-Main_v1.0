package com.example.saludate;

public class MedicalTest_Object {

    private String document, done_by, fecha;

    public MedicalTest_Object() {
    }

    public MedicalTest_Object(String document, String done_by, String fecha) {
        this.document = document;
        this.done_by = done_by;
        this.fecha = fecha;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDone_by() {
        return done_by;
    }

    public void setDone_by(String done_by) {
        this.done_by = done_by;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
