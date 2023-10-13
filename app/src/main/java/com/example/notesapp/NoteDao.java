package com.example.notesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {


    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);
     @Query("DELETE FROM notes_table")
    void deleteAllNotes();
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    LiveData<List<Note>> getAllNotes();
}
