package com.example.samplecomposeapp.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun ProduceStateDemo(modifier: Modifier = Modifier) {
  
}

@Preview
@Composable
private fun ProduceStateDemoPrev() {
  SampleComposeAppTheme {
    ProduceStateDemo()
  }
}