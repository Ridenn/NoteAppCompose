package com.lucas.noteappcompose.notes.presentation.notes.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.noteappcompose.notes.domain.model.Note
import com.lucas.noteappcompose.notes.domain.usecase.NoteUseCases
import com.lucas.noteappcompose.notes.domain.utils.NoteOrder
import com.lucas.noteappcompose.notes.domain.utils.OrderType
import com.lucas.noteappcompose.notes.presentation.notes.NotesEvent
import com.lucas.noteappcompose.notes.presentation.notes.NotesState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

//@HiltViewModel
class NotesViewModel(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var lastDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        viewModelScope.launch {
            getNotes(NoteOrder.Date(OrderType.Descending))
        }
    }

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.Order -> {
                if(state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType)
                {
                    return
                }
                viewModelScope.launch {
                    getNotes(event.noteOrder)
                }
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNoteUseCase(event.note)
                    lastDeletedNote = event.note
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !_state.value.isOrderSectionVisible
                )
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNoteUseCase(lastDeletedNote ?: return@launch)
                    lastDeletedNote = null
                }
            }
        }
    }

    private suspend fun getNotes(noteOrder: NoteOrder) {
        // Cancel the job that observes the DB if it's already running before starting a new one
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotesUseCase(noteOrder).onEach { notes ->
            _state.value = state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}