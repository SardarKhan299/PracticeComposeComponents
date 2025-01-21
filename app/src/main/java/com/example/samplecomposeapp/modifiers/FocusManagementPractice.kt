package com.example.samplecomposeapp.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun FocusManagementPractice(modifier: Modifier = Modifier) {

  val focusRequester = remember {
    FocusRequester()
  }
  val focusManager = LocalFocusManager.current

  // You can apply focus on TextField..//
  Column(
    modifier = Modifier.fillMaxSize()
      .background(Color.White)
      .padding(top = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    TextField(
      value = "",
      onValueChange = {

      },
      modifier = Modifier
        .focusRequester(focusRequester),
      keyboardActions = KeyboardActions(
        onNext = {
          focusManager.moveFocus(FocusDirection.Down)
        }
      ),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
      )
    )
    TextField(
      value = "",
      onValueChange = {

      },
      keyboardActions = KeyboardActions(
        onNext = {
          focusManager.moveFocus(FocusDirection.Down)
        }
      ),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
      )
    )
    var isFocused by remember {
      mutableStateOf(false)
    }
    // Box are not by default focusable..//
    Box(
      modifier = Modifier.fillMaxWidth()
        .height(100.dp)
        .border(
          width = 4.dp,
          color = if(isFocused) Color.Red else Color.Green
        )
        .onFocusChanged {
          isFocused = it.isFocused
        }
        .focusable()
    )
    TextField(
      value = "",
      onValueChange = {

      }
    )

    Button(onClick = {
      focusRequester.requestFocus()
    }) {
      Text(text = "Start Filling The Form")
    }
  }

}

@Preview
@Composable
private fun FocusManagementPracticePrev() {
  SampleComposeAppTheme {
    FocusManagementPractice()
  }
}