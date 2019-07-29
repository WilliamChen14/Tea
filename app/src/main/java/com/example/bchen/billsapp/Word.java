package com.example.bchen.billsapp;

import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

import androidx.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String Name;

    @ColumnInfo(name = "number")
    public String Number;

    @ColumnInfo(name = "color")
    public String FavColor;

    @ColumnInfo(name = "age")
    public Integer Age;

    @ColumnInfo(name = "birthday")
    public String Birthday;

    @ColumnInfo(name = "animal")
    public String FavAnimal;


}