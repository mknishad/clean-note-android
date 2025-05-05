package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) {

  suspend operator fun invoke(id: Int): Note? {
    return repository.getNoteById(id)
  }
}