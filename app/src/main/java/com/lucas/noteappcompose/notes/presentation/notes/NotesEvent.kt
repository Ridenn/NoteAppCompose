package com.lucas.noteappcompose.notes.presentation.notes

import com.lucas.noteappcompose.notes.domain.model.Note
import com.lucas.noteappcompose.notes.domain.utils.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}
