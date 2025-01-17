package com.example.samplecomposeapp.statemanagement.todo_list_check

import java.util.UUID

data class TodoListState (
  val id: String = UUID.randomUUID().toString(),
  val title: String ="",
  val description: String="",
  val isChecked: Boolean = false,
  val isDeleted: Boolean = false
)