package com.example.saludate;

public class RegisterUser_Object {
    String name, gender, age, birthday, status, date, checkin, bed, days, blood, inor, recordnum, dig, condition;

    public RegisterUser_Object() {
    }

    public RegisterUser_Object(String name, String gender, String age, String birthday, String status, String date, String checkin, String bed, String days, String blood, String inor, String recordnum, String dig, String condition) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.status = status;
        this.date = date;
        this.checkin = checkin;
        this.bed = bed;
        this.days = days;
        this.blood = blood;
        this.inor = inor;
        this.recordnum = recordnum;
        this.dig = dig;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getInor() {
        return inor;
    }

    public void setInor(String inor) {
        this.inor = inor;
    }

    public String getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(String recordnum) {
        this.recordnum = recordnum;
    }

    public String getDig() {
        return dig;
    }

    public void setDig(String dig) {
        this.dig = dig;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
