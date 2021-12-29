package com.codiaries.jot.fragments.vms;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.codiaries.jot.data.repos.noteRepository;
import com.codiaries.jot.model.Note;

import java.util.List;

public class NotesVM extends AndroidViewModel {

    private noteRepository mRepo;
    private LiveData<List<Note>> mNotes;

    public NotesVM (Application application) {
        super(application);
        mRepo = new noteRepository(application);
        mNotes = mRepo.getAllNotes();
    }

    public LiveData<List<Note>> getmNotes() { return mNotes; }

    public void insertNote(Note note) { mRepo.insert(note); }
}
