package com.lucas.noteappcompose.notes.domain.usecase

import com.lucas.noteappcompose.notes.domain.model.InvalidNoteException
import com.lucas.noteappcompose.notes.domain.model.Note
import com.lucas.noteappcompose.notes.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        withContext(Dispatchers.IO) {
            if (note.title.isBlank()) {
                throw InvalidNoteException("O título da nota não pode estar vazio")
            }
            if(note.content.isBlank()) {
                throw InvalidNoteException("O conteúdo da nota não pode estar vazio")
            }
            repository.insertNote(note)
        }
    }
}