package com.example.samplecomposeapp.statemanagement.todo_list_check

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.samplecomposeapp.statemanagement.number_guess.NumberGuessState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

class TodoListViewModel: ViewModel() {

  private val _state = MutableStateFlow(
    listOf(
      TodoListState("1","Test", "Test Desc", false ,   false),
      TodoListState("2","Test1", "Test1 Desc", false ,   false),
      TodoListState("3","Test2", "Test2 Desc", false ,   false)
    )
  )
  val state = _state.asStateFlow()

  val listOfItem: List<TodoListState>
    get() = _state.value


  fun onAction(action: TodoListActions){
    when(action){

      is TodoListActions.OnCheckedClick -> {
        val updatedList = listOfItem.map { item ->
          if (item.id == action.id) {
            item.copy(isChecked = !item.isChecked)
          } else item
        }
        _state.value = updatedList
      }
      is TodoListActions.OnDeleteClick -> {
        val updatedList = listOfItem.filter { it.id != action.id }
        _state.value = updatedList
      }

      is TodoListActions.OnAddItemClicked -> {
        val newItem = TodoListState(
          id = UUID.randomUUID().toString(),
          title = action.title,
          description = action.desc,
          isChecked = false,
          isDeleted = false
        )
        _state.value = listOfItem + newItem
      }

    }
  }

}