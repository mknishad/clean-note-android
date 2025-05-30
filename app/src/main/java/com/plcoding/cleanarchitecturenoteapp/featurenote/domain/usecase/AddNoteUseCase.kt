package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {

  @Throws(InvalidNoteException::class)
  suspend operator fun invoke(note: Note) {
    if (note.title.isBlank()) {
      throw InvalidNoteException("The title of the note can't be empty.")
    }
    if (note.content.isBlank()) {
      throw InvalidNoteException("The content of the note can't be empty.")
    }
    repository.insertNote(note)
  }
}