package com.example.samplecomposeapp.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.measurements.utility.printConstraints
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun SizeModifierPractice(modifier: Modifier = Modifier) {
  Row(
    modifier = Modifier
      .height(100.dp)
      .fillMaxWidth()
      .background(Color.Red)
  ){
    Box(
      modifier = Modifier
        .height(100.dp)
        .printConstraints("Before 1. FillMaxWidth")
        .requiredWidth(300.dp)
        .printConstraints("After 1. FillMaxWidth")
        .background(Color.Yellow)
    ){

    }

    Box(
      modifier = Modifier
        .height(100.dp)
        .printConstraints("Before 2. FillMaxWidth")
        .requiredWidth(300.dp)
        .printConstraints("After 2. FillMaxWidth")
        .background(Color.Green)
    ){

    }
  }
}


@Preview(showBackground = true)
@Composable
private fun SizeModifierPracticePrev() {
  SampleComposeAppTheme {
    SizeModifierPractice()
  }
}
