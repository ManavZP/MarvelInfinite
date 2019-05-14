package com.hfad.marvelinfinite;

import android.os.Parcel;
import android.os.Parcelable;

public class FavCharacter implements Parcelable {

    // name, cuisine, rating, link to website/yelp, price, address
    private String name;
    private String imgUrl; // 1->5 with 1 increments

    private String ownerId;
    private String objectId;

    // need a default constructor for Backendless
    public FavCharacter() {
    }


    public FavCharacter(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.imgUrl);
        dest.writeString(this.ownerId);
        dest.writeString(this.objectId);
    }

    protected FavCharacter(Parcel in) {
        this.name = in.readString();
        this.imgUrl = in.readString();
        this.ownerId = in.readString();
        this.objectId = in.readString();
    }

    public static final Parcelable.Creator<FavCharacter> CREATOR = new Parcelable.Creator<FavCharacter>() {
        @Override
        public FavCharacter createFromParcel(Parcel source) {
            return new FavCharacter(source);
        }

        @Override
        public FavCharacter[] newArray(int size) {
            return new FavCharacter[size];
        }
    };
}


