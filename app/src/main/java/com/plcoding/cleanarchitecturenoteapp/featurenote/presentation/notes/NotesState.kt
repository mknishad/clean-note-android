package com.plcoding.cleanarchitecturenoteapp.featurenote.presentation.notes

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.util.OrderType

data class NotesState(
  val notes: List<Note> = emptyList(),
  val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
  val isOrderSectionVisible: Boolean = false
)
