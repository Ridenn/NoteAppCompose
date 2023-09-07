package com.lucas.noteappcompose.notes.data.datasrc

import android.content.Context
import androidx.room.Room
import com.lucas.noteappcompose.notes.data.datasrc.NoteDatabase.Companion.DATABASE_NAME

object DatabaseProvider {
    fun getDatabase(context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}