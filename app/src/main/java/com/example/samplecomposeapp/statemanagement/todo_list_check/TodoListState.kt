package com.example.samplecomposeapp.statemanagement.todo_list_check

data class TodoListState (
  val title: String ="",
  val description: String="",
  val isChecked: Boolean = false
)