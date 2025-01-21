package com.example.samplecomposeapp.statemanagement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun StateHoistingPractice(modifier: Modifier = Modifier) {

  var counter by rememberSaveable {
    mutableIntStateOf(0)
  }
  Column (
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(100.dp)
  ){
      Button(onClick = {
        counter = 0
      }) {
        Text(text = "Resent Counter.")
      }
      StatePractice(counter = counter,
        onCounterButtonClick = {
        counter++
      }, modifier = modifier)

  }

}



@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
private fun StateHoistingPrev() {
  SampleComposeAppTheme {
    StateHoistingPractice(modifier =  Modifier
      .background(Color.Red)

    )
  }
}