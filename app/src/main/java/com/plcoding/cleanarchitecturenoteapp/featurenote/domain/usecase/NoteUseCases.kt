package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase

data class NoteUseCases(
  val getNotesUseCase: GetNotesUseCase,
  val deleteNoteUseCase: DeleteNoteUseCase,
  val addNoteUseCase: AddNoteUseCase,
  val getNoteUseCase: GetNoteUseCase
)
