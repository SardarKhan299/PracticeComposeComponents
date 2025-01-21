package com.example.samplecomposeapp.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.statemanagement.todo_list_check.TodoListScreen
import com.example.samplecomposeapp.statemanagement.todo_list_check.TodoListState
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun ModifierPractice(modifier: Modifier = Modifier) {
  Box(
    modifier = Modifier
      .size(100.dp)
      .background(Color.Yellow)
      .clip(CircleShape)
      .background(Color.Red)
      .padding(8.dp)
      .clip(CircleShape)
      .background(Color.Blue)
    , contentAlignment = Alignment.Center
  ) {
    Text(
      text = "Hello World."
    )
  }
}


@Preview(showBackground = true)
@Composable
private fun ModifierPracticePrev() {
  SampleComposeAppTheme {
    ModifierPractice()
  }
}