package com.fourdt.musicgallery;


import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private String mName;
    private int mDuration;
    private int mRating;

    public Song( String name, int duration) {
        this.mName = name;
        this.mDuration = duration;
        mRating = 0;
    }

    public String getName() {
        return mName;
    }

    public int getDuration() {
        return mDuration;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        this.mRating = rating;
    }

    protected Song(Parcel in) {
        mName = in.readString();
        mDuration = in.readInt();
        mRating = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mDuration);
        dest.writeInt(mRating);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}