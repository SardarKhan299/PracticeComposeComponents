package com.example.samplecomposeapp.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun SpacingModifierPractice(modifier: Modifier = Modifier) {

  Column (
    modifier = modifier
      .fillMaxSize()
      .navigationBarsPadding()
      .statusBarsPadding()
      .safeGesturesPadding()
      .background(Color.Red)
  ){
    Text(
      text = "Testing Text.."
    )
    Spacer(
      modifier = Modifier
        .height(16.dp)
    )
    Text(
      text = "Testing Text 123"
    )
  }
}


@Preview
@Composable
private fun SpacingModifierPracticePrev() {
  SampleComposeAppTheme {
    SpacingModifierPractice()
  }
}