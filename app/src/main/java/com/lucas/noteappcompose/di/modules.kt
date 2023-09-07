package com.lucas.noteappcompose.di

import android.app.Application
import androidx.room.Room
import com.lucas.noteappcompose.notes.data.datasrc.NoteDatabase
import com.lucas.noteappcompose.notes.data.datasrc.NoteDatabase.Companion.DATABASE_NAME
import com.lucas.noteappcompose.notes.data.repository.NoteRepositoryImpl
import com.lucas.noteappcompose.notes.domain.repository.NoteRepository
import com.lucas.noteappcompose.notes.domain.usecase.AddNoteUseCase
import com.lucas.noteappcompose.notes.domain.usecase.DeleteNoteUseCase
import com.lucas.noteappcompose.notes.domain.usecase.GetNoteUseCase
import com.lucas.noteappcompose.notes.domain.usecase.GetNotesUseCase
import com.lucas.noteappcompose.notes.domain.usecase.NoteUseCases
import com.lucas.noteappcompose.notes.presentation.addeditnote.viewmodel.AddEditNoteViewModel
import com.lucas.noteappcompose.notes.presentation.notes.viewmodel.NotesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//val mainModule = module {
//    single<NoteRepository> { NoteRepositoryImpl(get()) }
//
//    single { AddNoteUseCase(get()) }
//    single { DeleteNoteUseCase(get()) }
//    single { GetNotesUseCase(get()) }
//    single { GetNoteUseCase(get()) }
//    single { NoteUseCases(get(), get(), get(), get()) }
//
//    viewModel {
//        AddEditNoteViewModel(
//            noteUseCases = get(),
//            savedStateHandle = get()
//        )
//    }
//
//    viewModel {
//        NotesViewModel(
//            noteUseCases = get()
//        )
//    }
//}

val appModule = module {
    single<NoteRepository> { NoteRepositoryImpl(get()) }

    single { provideNoteDatabase(androidApplication()) }
    single { provideNoteRepository(get()) }
    single { provideNoteUseCases(get()) }

    viewModel {
        AddEditNoteViewModel(
            noteUseCases = get(),
            savedStateHandle = get()
        )
    }

    viewModel {
        NotesViewModel(
            noteUseCases = get()
        )
    }
}

fun provideNoteDatabase(app: Application): NoteDatabase {
    return Room.databaseBuilder(
        app,
        NoteDatabase::class.java,
        DATABASE_NAME
    ).build()
}

fun provideNoteRepository(db: NoteDatabase): NoteRepository {
    return NoteRepositoryImpl(db.noteDao)
}

fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
    return NoteUseCases(
        getNotesUseCase = GetNotesUseCase(repository),
        deleteNoteUseCase = DeleteNoteUseCase(repository),
        addNoteUseCase = AddNoteUseCase(repository),
        getNoteUseCase = GetNoteUseCase(repository)
    )
}