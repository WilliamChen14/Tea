package com.example.bchen.billsapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

import androidx.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "number")
    public String number;

    @ColumnInfo(name = "color")
    public String favColor;

    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "birthday")
    public String birthday;

    @ColumnInfo(name = "animal")
    public String favAnimal;

    @ColumnInfo(name = "hobby")
    public String hobby;

    @ColumnInfo(name = "song")
    public String song;

    //@ColumnInfo


    public Word(String name, String number, String favColor, int age, String birthday, String favAnimal, String hobby, String song){
        this.name=name;
        this.number = number;
        this.favColor = favColor;
        this.age = age;
        this.birthday = birthday;
        this.favAnimal = favAnimal;
        this.hobby = hobby;
        this.song = song;
    }

    public Word(Parcel in){
        this.name = in.readString();
        this.number = in.readString();
        this.favColor = in.readString();
        this.age = in.readInt();
        this.birthday = in.readString();
        this.favAnimal = in.readString();
        this.hobby = in.readString();
        this.song = in.readString();
    }


    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeString(number);
        dest.writeString(favColor);
        dest.writeInt(age);
        dest.writeString(birthday);
        dest.writeString(favAnimal);
        dest.writeString(hobby);
        dest.writeString(song);

    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) { return new Word(in);}

        @Override
        public Word[] newArray(int i) { return new Word[i];}
    };

    public String getFavColor(){
        return favColor;
    }
    public String getName(){
        return name;
    }


}