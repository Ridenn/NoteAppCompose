package com.lucas.noteappcompose.notes.domain.repository

import androidx.lifecycle.LiveData
import com.lucas.noteappcompose.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}