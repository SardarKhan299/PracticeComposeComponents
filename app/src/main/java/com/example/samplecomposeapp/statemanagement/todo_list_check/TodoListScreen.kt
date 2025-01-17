package com.example.samplecomposeapp.statemanagement.todo_list_check

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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


@Composable
fun TodoListScreenRoot(modifier: Modifier = Modifier) {
  val viewModel = viewModel<TodoListViewModel>()
  val state by viewModel.state.collectAsStateWithLifecycle()
  TodoListScreen(modifier = modifier,
    state = state,
    onAction = viewModel::onAction // pass action to viewModel to handle..//
  )
}

@Composable
fun TodoListScreen(modifier: Modifier = Modifier,state: TodoListState,
                   onAction: (TodoListActions)-> Unit) {

  Log.d(TodoListState::class.simpleName, ": State Changed.....${state.isChecked}")
  Row(
    modifier = modifier.fillMaxWidth()
      .padding(22.dp),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.spacedBy(8.dp,Alignment.CenterVertically)
    ) {
      Text(text = "Bring out the trash",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        textDecoration = if (state.isChecked) TextDecoration.LineThrough else TextDecoration.None
        )
      Text(text = "Better do this before wife comes home.",
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        textDecoration = if (state.isChecked) TextDecoration.LineThrough else TextDecoration.None
      )
    }
    Checkbox(
      checked = state.isChecked,
      onCheckedChange = {
        onAction(TodoListActions.OnCheckedClick)
      }
    )

  }
}

@Preview(showBackground = true)
@Composable
private fun TodoListScreenPrev() {
  SampleComposeAppTheme {
    TodoListScreen(
      state = TodoListState(),
      onAction = {}
    )
  }
}