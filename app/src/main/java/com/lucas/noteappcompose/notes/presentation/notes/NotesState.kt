package com.lucas.noteappcompose.notes.presentation.notes

import com.lucas.noteappcompose.notes.domain.model.Note
import com.lucas.noteappcompose.notes.domain.utils.NoteOrder
import com.lucas.noteappcompose.notes.domain.utils.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
