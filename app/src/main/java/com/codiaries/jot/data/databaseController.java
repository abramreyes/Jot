package com.codiaries.jot.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codiaries.jot.data.daos.notesDao;
import com.codiaries.jot.model.Note;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class databaseController extends RoomDatabase {

    public static final String DB_NAME = "jotCortex_db";
    private static databaseController instance;
    public static final int NO_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NO_OF_THREADS);

    public static synchronized databaseController getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), databaseController.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract notesDao notesDao();

}
