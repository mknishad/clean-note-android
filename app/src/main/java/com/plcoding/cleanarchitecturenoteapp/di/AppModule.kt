package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.featurenote.data.datasource.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.featurenote.data.repository.NoteRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.AddNoteUseCase
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.DeleteNoteUseCase
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.GetNoteUseCase
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.GetNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Provides
  @Singleton
  fun provideNoteDatabase(app: Application): NoteDatabase {
    return Room.databaseBuilder(
      app,
      NoteDatabase::class.java,
      NoteDatabase.DATABASE_NAME
    ).build()
  }

  @Provides
  @Singleton
  fun provideNoteRepository(db: NoteDatabase): NoteRepository {
    return NoteRepositoryImpl(db.noteDao)
  }

  @Provides
  @Singleton
  fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
    return NoteUseCases(
      getNotesUseCase = GetNotesUseCase(repository),
      getNoteUseCase = GetNoteUseCase(repository),
      addNoteUseCase = AddNoteUseCase(repository),
      deleteNoteUseCase = DeleteNoteUseCase(repository)
    )
  }
}