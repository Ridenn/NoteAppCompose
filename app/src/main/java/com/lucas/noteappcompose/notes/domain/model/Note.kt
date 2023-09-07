package com.lucas.noteappcompose.notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lucas.noteappcompose.ui.theme.BabyBlue
import com.lucas.noteappcompose.ui.theme.LightGreen
import com.lucas.noteappcompose.ui.theme.RedOrange
import com.lucas.noteappcompose.ui.theme.RedPink
import com.lucas.noteappcompose.ui.theme.Violet

@Entity(tableName = "notes")
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)