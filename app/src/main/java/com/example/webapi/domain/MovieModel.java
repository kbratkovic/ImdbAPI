package com.example.webapi.domain;

import android.os.Parcel;
import android.os.Parcelable;


public class MovieModel implements Parcelable {
    String id;
    String resultType;
    String image;
    String title;
    String description;

    protected MovieModel(Parcel in) {
        id = in.readString();
        resultType = in.readString();
        image = in.readString();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(resultType);
        parcel.writeString(image);
        parcel.writeString(title);
        parcel.writeString(description);
    }


    public String getId() {
        return id;
    }

    public String getResultType() {
        return resultType;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}





