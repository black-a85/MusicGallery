package com.fourdt.musicgallery;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Album implements Parcelable {
    private String mAlbumName;
    private String mArtist;
    private int mAlbumArt;
    private ArrayList<Song> mSongs;

    public Album(String mAlbumName, String mArtist, int albumArt) {
        this.mAlbumName = mAlbumName;
        this.mArtist = mArtist;
        this.mAlbumArt = albumArt;
        this.mSongs = new ArrayList<>();
    }

    public void addSong (Song song){
        mSongs.add(song);
    }

    public void addSong (String name, int duration){
        mSongs.add(new Song(name,duration));
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getArtist() {
        return mArtist;
    }

    public ArrayList<Song> getSongs() {
        return mSongs;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    protected Album(Parcel in) {
        mAlbumName = in.readString();
        mArtist = in.readString();
        mAlbumArt = in.readInt();
        if (in.readByte() == 0x01) {
            mSongs = new ArrayList<Song>();
            in.readList(mSongs, Song.class.getClassLoader());
        } else {
            mSongs = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAlbumName);
        dest.writeString(mArtist);
        dest.writeInt(mAlbumArt);
        if (mSongs == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mSongs);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}