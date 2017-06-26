package com.jx3.yanqijs.jx3equipment.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yanqijs on 2016/11/17.
 */

public class M implements Parcelable {
    //    public String id;
//    public String name;
//    public String money;
    public String a;

    protected M(Parcel in) {
        a = in.readString();
    }

    public static final Creator<M> CREATOR = new Creator<M>() {
        @Override
        public M createFromParcel(Parcel in) {
            return new M(in);
        }

        @Override
        public M[] newArray(int size) {
            return new M[size];
        }
    };

    public M(String a) {
        this.a = a;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(a);
    }
}
