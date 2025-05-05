package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {

  suspend operator fun invoke(note: Note) {
    repository.deleteNote(note)
  }
}