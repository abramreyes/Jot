package com.codiaries.jot.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int noteId;
    private String noteTitle;
    private String noteDescription;
    private String noteImageImport;
    private String noteChecklist;
    private int notePriority;

    public Note () {

    }

    @Ignore
    public Note (int noteId, String noteTitle, String noteDescription, String noteImageImport, String noteChecklist){
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.noteImageImport = noteImageImport;
        this.noteChecklist = noteChecklist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public String getNoteImageImport() {
        return noteImageImport;
    }

    public String getNoteChecklist() {
        return noteChecklist;
    }

    public int getNotePriority() {
        return notePriority;
    }


    //Setters

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public void setNoteImageImport(String noteImageImport) {
        this.noteImageImport = noteImageImport;
    }

    public void setNoteChecklist(String noteChecklist) {
        this.noteChecklist = noteChecklist;
    }

    public void setNotePriority(int notePriority) {
        this.notePriority = notePriority;
    }
}
