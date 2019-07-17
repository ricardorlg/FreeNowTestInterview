package com.freenow.android_demo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.Objects;

public class Driver implements Parcelable {

    private String mName;
    private String mPhone;
    private String mAvatar;
    private String mLocation;
    private Date mRegisteredDate;

    public Driver(String name, String phone, String avatar, String location, Date registeredDate) {
        mName = name;
        mPhone = phone;
        mAvatar = avatar;
        mLocation = location;
        mRegisteredDate = registeredDate;
    }

    private Driver(Parcel parcel) {
        mName = parcel.readString();
        mPhone = parcel.readString();
        mAvatar = parcel.readString();
        mLocation = parcel.readString();
        mRegisteredDate = new Date(parcel.readLong());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return mName.equals(driver.mName) &&
                mPhone.equals(driver.mPhone) &&
                mAvatar.equals(driver.mAvatar) &&
                mLocation.equals(driver.mLocation) &&
                mRegisteredDate.equals(driver.mRegisteredDate);
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mPhone);
        parcel.writeString(mAvatar);
        parcel.writeString(mLocation);
        parcel.writeLong(mRegisteredDate.getTime());
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public String getLocation() {
        return mLocation;
    }

    public Date getRegisteredDate() {
        return mRegisteredDate;
    }

    public static final Creator<Driver> CREATOR = new Creator<Driver>() {
        @Override
        public Driver createFromParcel(Parcel parcel) {
            return new Driver(parcel);
        }

        @Override
        public Driver[] newArray(int size) {
            return new Driver[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Driver: "+mName;
    }
}
