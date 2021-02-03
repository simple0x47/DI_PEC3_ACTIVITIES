package com.gabrielamihalachioaie.agenda;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AgendaEntry implements Parcelable {
    public String fullName;
    public GregorianCalendar birthDate;
    public String phoneNumber;
    public String email;
    public String description;

    public AgendaEntry(String fullName, GregorianCalendar birthDate,
                       String phoneNumber, String email, String description) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
    }

    protected AgendaEntry(Parcel in) {
        fullName = in.readString();
        birthDate = new GregorianCalendar(in.readInt(), in.readInt(), in.readInt());
        phoneNumber = in.readString();
        email = in.readString();
        description = in.readString();
    }

    public static final Creator<AgendaEntry> CREATOR = new Creator<AgendaEntry>() {
        @Override
        public AgendaEntry createFromParcel(Parcel in) {
            return new AgendaEntry(in);
        }

        @Override
        public AgendaEntry[] newArray(int size) {
            return new AgendaEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(fullName);
        dest.writeInt(birthDate.get(Calendar.YEAR));
        dest.writeInt(birthDate.get(Calendar.MONTH));
        dest.writeInt(birthDate.get(Calendar.DAY_OF_MONTH));
        dest.writeString(phoneNumber);
        dest.writeString(email);
        dest.writeString(description);
    }
}
