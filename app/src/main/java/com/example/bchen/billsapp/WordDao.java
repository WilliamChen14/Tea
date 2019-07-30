
package com.example.bchen.billsapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Delete
    void deleteContact(Word word);

    @Query("SELECT * from word_table")
    LiveData<List<Word>> getAllWords();

    @Update
    void updateContact(Word word);
}
