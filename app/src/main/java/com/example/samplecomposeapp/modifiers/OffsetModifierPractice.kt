package com.example.samplecomposeapp.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun OffsetModifierPractice(modifier: Modifier = Modifier) {
  Column (
    modifier = Modifier.size(200.dp)
      .background(Color.Red)
      .offset(
        x = 50.dp,
        y = 20.dp
      )
  ){

    Text(text ="Testing Text",
      modifier = modifier
        .background(Color.Blue)
        .offset(x = 10.dp,
          y = 2.dp)
      )

    Text(text ="Testing Text2",
      modifier = modifier.background(Color.Yellow)
    )
  }
}

@Preview
@Composable
private fun OffsetModifierPracticePrev() {
  SampleComposeAppTheme {
    OffsetModifierPractice()
  }
}