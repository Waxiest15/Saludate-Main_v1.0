package com.example.saludate;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

public class MedicineRegisterModel implements Parcelable {
    private String medicineName, dosage, time, intervals, via, medicineID;

    public MedicineRegisterModel() {
    }

    public MedicineRegisterModel(String medicineID,String dosage,String medicineName, String time, String intervals, String via) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.time = time;
        this.intervals = intervals;
        this.via = via;
        this.medicineID = medicineID;
    }

    protected MedicineRegisterModel(Parcel in) {
        medicineID = in.readString();
        dosage = in.readString();
        medicineName = in.readString();
        time = in.readString();
        via = in.readString();
        intervals = in.readString();
    }

    public static final Creator<MedicineRegisterModel> CREATOR = new Creator<MedicineRegisterModel>() {
        @Override
        public MedicineRegisterModel createFromParcel(Parcel in) {
            return new MedicineRegisterModel(in);
        }

        @Override
        public MedicineRegisterModel[] newArray(int size) {
            return new MedicineRegisterModel[size];
        }
    };

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(medicineID);
        dest.writeString(dosage);
        dest.writeString(medicineName);
        dest.writeString(via);
        dest.writeString(time);
        dest.writeString(intervals);
    }
}

