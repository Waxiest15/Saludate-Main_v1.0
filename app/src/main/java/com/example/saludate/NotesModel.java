package com.example.saludate;

import android.os.Parcel;
import android.os.Parcelable;

public class NotesModel implements Parcelable {
    private String medicineName;

    public NotesModel() {
    }

    public NotesModel(String medicineName) {
        this.medicineName = medicineName;
    }

    protected NotesModel(Parcel in) {
        medicineName = in.readString();
    }

    public static final Creator<NotesModel> CREATOR = new Creator<NotesModel>() {
        @Override
        public NotesModel createFromParcel(Parcel in) {
            return new NotesModel(in);
        }

        @Override
        public NotesModel[] newArray(int size) {
            return new NotesModel[size];
        }
    };

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(medicineName);
    }
}
