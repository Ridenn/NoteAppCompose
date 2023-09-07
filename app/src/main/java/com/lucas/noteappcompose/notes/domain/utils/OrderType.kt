package com.lucas.noteappcompose.notes.domain.utils

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
