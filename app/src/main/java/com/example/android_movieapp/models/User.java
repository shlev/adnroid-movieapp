package com.example.android_movieapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;
    private String email;
    private String password;
    private String cellphone;
    private String firstName;
    private String lastName;

    public User(int id, String email, String password, String cellphone, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.cellphone = cellphone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected User(Parcel in) {
        id = in.readInt();
        email = in.readString();
        password = in.readString();
        cellphone = in.readString();
        firstName = in.readString();
        lastName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(cellphone);
        dest.writeString(firstName);
        dest.writeString(lastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
