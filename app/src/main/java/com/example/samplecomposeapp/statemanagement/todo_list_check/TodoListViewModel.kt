package com.example.samplecomposeapp.statemanagement.todo_list_check

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.samplecomposeapp.statemanagement.number_guess.NumberGuessState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel: ViewModel() {
  private val _state = MutableStateFlow(TodoListState())
  val state = _state.asStateFlow()

  fun onAction(action: TodoListActions){
    when(action){
      TodoListActions.OnCheckedClick -> {
        Log.d(TodoListState::class.simpleName, ": Checked Clicked...${_state.value.isChecked}")
        _state.update { it.copy(
            isChecked = !_state.value.isChecked
          )
        }
      }
    }
  }

}