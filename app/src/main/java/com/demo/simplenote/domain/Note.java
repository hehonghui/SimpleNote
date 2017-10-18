package com.demo.simplenote.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by mrsimple on 17/10/17.
 */

public class Note implements Comparable<Note> , Parcelable {
    public int id ;
    public long modifyTimeStamp ;
    public String title = "";
    public String content = "";

    public Note() {
    }

    protected Note(Parcel in) {
        id = in.readInt() ;
        modifyTimeStamp = in.readLong();
        title = in.readString();
        content = in.readString();
    }

    @Override
    public int compareTo(@NonNull Note o) {
        return (int)(o.modifyTimeStamp - this.modifyTimeStamp);
    }

    @Override
    public String toString() {
        return "Note{" + "title='" + title + '\'' + '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeLong(modifyTimeStamp);
        dest.writeString(title);
        dest.writeString(content);
    }


    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
