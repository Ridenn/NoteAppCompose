package com.lucas.noteappcompose.notes.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.noteappcompose.notes.domain.utils.NoteOrder
import com.lucas.noteappcompose.notes.domain.utils.OrderType
import com.lucas.noteappcompose.notes.presentation.notes.components.DefaultRadioButton

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(text = "Título",
                selected = noteOrder is NoteOrder.Title,
                onSelected = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Data",
                selected = noteOrder is NoteOrder.Date,
                onSelected = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
            DefaultRadioButton(text = "Cor",
                selected = noteOrder is NoteOrder.Color,
                onSelected = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(text = "Crescente",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelected = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Decrescente",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelected = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}