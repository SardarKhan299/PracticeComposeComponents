package com.example.samplecomposeapp.statemanagement.number_guess

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.samplecomposeapp.statemanagement.StateHoistingPractice
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun NumberGuessScreenRoot(modifier: Modifier = Modifier) {
  val viewModel = viewModel<NumberGuessViewModel>()
  val state by viewModel.state.collectAsStateWithLifecycle()
  StateManagementGame(modifier = modifier,
    state = state,
    onAction = viewModel::onAction // pass action to viewModel to handle..//
  )
}

@Composable
fun StateManagementGame(state: NumberGuessState,
                        modifier: Modifier = Modifier,
                        onAction: (NumberGuessAction)-> Unit) {

  Column (
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(16.dp,Alignment.CenterVertically)
  ){
   TextField(
     value = state.numberText,
     onValueChange = { newText->
       onAction(NumberGuessAction.OnNumberTextChange(newText))
     },
     label = {
       Text(text = "Enter Number")
     }
   )
  }
  
}

@PreviewScreenSizes
@PreviewLightDark
@Composable
@Preview(showBackground = true)
private fun StateManagementGamePrev() {
  SampleComposeAppTheme {
  StateManagementGame(
    state = NumberGuessState(numberText = "12345",
      guessText = "",
      isGuessCorrect = false
      ),
    onAction = {}
  )
  }
}