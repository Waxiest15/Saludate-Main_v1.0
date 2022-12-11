package com.example.saludate;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String Id;
    private String name;
    private String email;
    private String phone;

    public UserModel() {
    }

    public UserModel(String id, String name, String email, String phone) {
        Id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    protected UserModel(Parcel in) {
        Id = in.readString();
        name = in.readString();
        email = in.readString();
        phone = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(phone);
    }
}