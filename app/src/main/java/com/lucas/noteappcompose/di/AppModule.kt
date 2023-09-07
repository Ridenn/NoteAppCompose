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

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideNoteDatabase(app: Application) : NoteDatabase {
//        return Room.databaseBuilder(
//            app,
//            NoteDatabase::class.java,
//            DATABASE_NAME
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideNoteRepository(db: NoteDatabase) = NoteRepositoryImpl(db.noteDao)
//
//    @Provides
//    @Singleton
//    fun provideNoteUseCases(repository: NoteRepository) =
//        NoteUseCases(
//            getNotesUseCase = GetNotesUseCase(repository),
//            deleteNoteUseCase = DeleteNoteUseCase(repository),
//            addNoteUseCase = AddNoteUseCase(repository),
//            getNoteUseCase = GetNoteUseCase(repository)
//        )
//}