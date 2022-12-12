package com.example.saludate;

public class Medicine_Object {

    String M_ID, dosis, intervals, name, time, via;

    public Medicine_Object() {
    }

    public Medicine_Object(String m_ID, String dosis, String intervals, String name, String time, String via) {
        M_ID = m_ID;
        this.dosis = dosis;
        this.intervals = intervals;
        this.name = name;
        this.time = time;
        this.via = via;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 }

