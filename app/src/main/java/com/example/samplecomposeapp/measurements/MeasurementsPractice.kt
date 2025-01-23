package com.example.samplecomposeapp.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


// Minimum and maximum bounds..//
private val boundedConstraints = Constraints(
  minWidth = 100,
  maxWidth = 200,
  minHeight = 100,
  maxHeight = 200
)
// Unbounded constraints..//
private val unBoundedConstraints = Constraints(
  minWidth = 100,
  maxWidth = 200,
  minHeight = 100,
  maxHeight = 200
)

private val exactConstraints = Constraints(
  minWidth = 100,
  maxWidth = 100,
  minHeight = 100,
  maxHeight = 100
)

private val combinedConstraints = Constraints(
  minWidth = 50,
  maxWidth = 50,
  minHeight = 100,
  maxHeight = Constraints.Infinity
)

@Composable
fun MeasurementsPractice(modifier: Modifier = Modifier) {

  Column (
    modifier = Modifier
      .background(Color.Red)
      .padding(16.dp)
  ){
    Text("This is a text ",
      modifier = Modifier
        .background(Color.Yellow)
    )
    Text("This is a Second text ",
      modifier = Modifier
        .background(Color.Green)
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun MeasurementsPracticePrev() {
  SampleComposeAppTheme {
    MeasurementsPractice()
  }

}