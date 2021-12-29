package com.codiaries.jot.data.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.codiaries.jot.data.daos.notesDao;
import com.codiaries.jot.data.databaseController;
import com.codiaries.jot.model.Note;

import java.util.List;

public class noteRepository {

    private notesDao notesDao;
    private LiveData<List<Note>> mNotes;

    public noteRepository(Application application){
        databaseController db = databaseController.getInstance(application);
        notesDao = db.notesDao();
        mNotes = notesDao.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return mNotes;
    }

    public void insert(Note note) {
        databaseController.databaseWriteExecutor.execute(() -> {
            notesDao.insertNote(note);
        });
    }

}
