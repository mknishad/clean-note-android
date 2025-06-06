package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {

  operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
    return repository.getNotes().map { notes ->
      when (noteOrder.orderType) {
        is OrderType.Ascending -> {
          when (noteOrder) {
            is NoteOrder.Title -> notes.sortedBy { it.title }
            is NoteOrder.Date -> notes.sortedBy { it.timestamp }
            is NoteOrder.Color -> notes.sortedBy { it.color }
          }
        }
        is OrderType.Descending -> {
          when (noteOrder) {
            is NoteOrder.Title -> notes.sortedByDescending { it.title }
            is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
            is NoteOrder.Color -> notes.sortedByDescending { it.color }
          }
        }
      }
    }
  }
}