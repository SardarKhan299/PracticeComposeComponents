package com.example.samplecomposeapp.statemanagement.todo_list_check

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.samplecomposeapp.statemanagement.number_guess.NumberGuessState
import com.example.samplecomposeapp.statemanagement.number_guess.NumberGuessViewModel
import com.example.samplecomposeapp.statemanagement.number_guess.StateManagementGame
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import com.example.samplecomposeapp.ui_practice.list.components.CustomItem


@Composable
fun TodoListScreenRoot(modifier: Modifier = Modifier) {
  val viewModel = viewModel<TodoListViewModel>()
  val state by viewModel.state.collectAsStateWithLifecycle()
  TodoListScreen(
    onAction = viewModel::onAction, // pass action to viewModel to handle..//
    list = state
  )
}

@Composable
fun TodoListScreen(modifier: Modifier = Modifier,
                   onAction: (TodoListActions)-> Unit,
                   list: List<TodoListState>) {
Column {
  LazyColumn(
    modifier = modifier.fillMaxSize()
      .weight(1f),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    contentPadding = PaddingValues(8.dp)
  ) {
    Log.d(TodoListState::class.simpleName, ": ");
    items(list) { item ->
      TodoListItem(modifier, item, onAction)
    }
  }
  AddTodoItem(modifier, onAction)
}
}

@Composable
fun TodoListItem(modifier: Modifier = Modifier,
                 state: TodoListState,
                 onAction: (TodoListActions) -> Unit) {
  Log.d(TodoListState::class.simpleName, ": TodoListItem State Changed.....${state.isChecked}");
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(22.dp),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(
      modifier = Modifier.weight(1f),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
      Text(
        text = state.title,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        textDecoration = if (state.isChecked) TextDecoration.LineThrough else TextDecoration.None
      )
      Text(
        text = state.description,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        textDecoration = if (state.isChecked) TextDecoration.LineThrough else TextDecoration.None
      )
    }
    Checkbox(
      checked = state.isChecked,
      onCheckedChange = {
        onAction(TodoListActions.OnCheckedClick(state.id))
      }
    )

    IconButton(onClick = {
      onAction(TodoListActions.OnDeleteClick(state.id))
    }) {
      Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = null
      )
    }

  }
  
}

@Composable
fun AddTodoItem(modifier: Modifier = Modifier,
                onAction: (TodoListActions) -> Unit) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(8.dp)
      .background(Color.Black),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    var title by remember { mutableStateOf("Enter Title") }
    var desc by remember { mutableStateOf("Enter Desc") }
    Column(
      modifier = Modifier.weight(1f),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
      TextField(value = title,
        onValueChange = { newText ->
          title = newText
        },
        readOnly = false,
        singleLine = true,
        maxLines = 1

      )

      TextField(value = desc,
        onValueChange = { newText ->
          desc = newText
        },
        readOnly = false,
        singleLine = false
      )

    }
    Button(
      modifier = modifier,
      onClick = {
        onAction(TodoListActions.OnAddItemClicked(title = title,
          desc = desc))
        title = ""
        desc = ""
      }
    ) {
        Text(text = "Add")
      }
    }

  }


@Preview(showBackground = true)
@Composable
private fun TodoListScreenPrev() {
  SampleComposeAppTheme {
    TodoListScreen(
      list = listOf(TodoListState()),
      onAction = {}
    )
  }
}