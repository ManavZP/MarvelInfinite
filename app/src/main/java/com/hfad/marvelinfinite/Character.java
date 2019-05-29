package com.hfad.marvelinfinite;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Character implements Parcelable {
    private String name;
    private int imageResource;
    private int video;
    private String status;
    private String bio;
    private int[] suggested;

    public Character (String name, int imageResource, int video, String status, String bio, int[] suggested){

        this.name = name;
        this.imageResource = imageResource;
        this.video = video;
        this.status = status;
        this.bio = bio;
        this.suggested = suggested;
    }

    protected Character(Parcel in) {
        name = in.readString();
        imageResource = in.readInt();
        video = in.readInt();
        status = in.readString();
        bio = in.readString();
        suggested = in.createIntArray();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getVideo() {
        return video;
    }

    public String getStatus() {
        return status;
    }

    public String getBio() {
        return bio;
    }


    public int[] getSuggested() {
        return suggested;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResource);
        dest.writeInt(video);
        dest.writeString(status);
        dest.writeString(bio);
        dest.writeIntArray(suggested);
    }
}
