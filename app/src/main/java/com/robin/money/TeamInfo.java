package com.robin.money;

import android.os.Parcel;
import android.os.Parcelable;

public class TeamInfo implements Parcelable {
    public final String name;
    public final String version;
    public final int membersCount;
    public String email;

    public TeamInfo(String name, String version, int membersCount) {
        this.name = name;
        this.version = version;
        this.membersCount = membersCount;
    }

    protected TeamInfo(Parcel in) {
        name = in.readString();
        version = in.readString();
        membersCount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(version);
        dest.writeInt(membersCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TeamInfo> CREATOR = new Creator<TeamInfo>() {
        @Override
        public TeamInfo createFromParcel(Parcel in) {
            return new TeamInfo(in);
        }

        @Override
        public TeamInfo[] newArray(int size) {
            return new TeamInfo[size];
        }
    };

    @Override
    public String toString() {
        return "TeamInfo{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", membersCount=" + membersCount +
                '}';
    }
}
