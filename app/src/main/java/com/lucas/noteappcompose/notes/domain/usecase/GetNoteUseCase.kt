package com.lucas.noteappcompose.notes.domain.usecase

import com.lucas.noteappcompose.notes.domain.model.Note
import com.lucas.noteappcompose.notes.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int) : Note? {
        return withContext(Dispatchers.IO) {
            repository.getNoteById(id)
        }
    }
}