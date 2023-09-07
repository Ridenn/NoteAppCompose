package com.lucas.noteappcompose.notes.presentation.addeditnote.viewmodel

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)