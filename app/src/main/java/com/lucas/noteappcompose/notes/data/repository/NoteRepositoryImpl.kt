package com.lucas.noteappcompose.notes.data.repository

import androidx.lifecycle.LiveData
import com.lucas.noteappcompose.notes.data.datasrc.NoteDao
import com.lucas.noteappcompose.notes.domain.model.Note
import com.lucas.noteappcompose.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override suspend fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note): Unit = dao.insertNote(note)

    override suspend fun deleteNote(note: Note): Unit = dao.deleteNote(note)
}