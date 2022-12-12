package com.example.saludate;

public class VitalSigns_Object {
    String alarms, time, value, name;

    public VitalSigns_Object() {
    }

    public VitalSigns_Object(String alarms, String time, String value) {
        this.alarms = alarms;
        this.time = time;
        this.value = value;
    }

    public String getAlarms() {
        return alarms;
    }

    public void setAlarms(String alarms) {
        this.alarms = alarms;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
