package com.example.samplecomposeapp.statemanagement.todo_list_check

import com.example.samplecomposeapp.statemanagement.number_guess.NumberGuessAction

sealed interface TodoListActions {
  data object OnCheckedClick: TodoListActions
}