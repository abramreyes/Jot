package com.codiaries.jot.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.codiaries.jot.model.Note;

import java.util.List;

@Dao
public interface notesDao {

    @Insert
    void insertNote(Note note);

    @Insert
    void insertAllNotes(Note... notes);

    @Update
    void updateNote(Note note);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNotes();

    @Delete
    void deleteNote(Note note);

    @Delete
    void deleteAllNotes(Note... notes);

}
