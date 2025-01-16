package com.example.samplecomposeapp.statemanagement

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import com.example.samplecomposeapp.ui_practice.PracticeScreens.HotelBookingScreen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


// this cannot be a state because its a constant and it cannot be changed over time....//
private const val BASE_URL = "https://...."

// never update state in composable function..//
// state should be update from...normal lambdas..or non composable lambdas..//

// compose state needs to update in a full..
/// avoid use mutable dataStructure in jetpack compose ..//
// mutableListof() and

@Composable
fun StatePractice(counter:Int,
                  onCounterButtonClick: ()-> Unit,
                  modifier: Modifier = Modifier) {
  // this can be used or served as a state..//
  // remember is used to cached the value across recomposition..//
  // and remember it can only be used in the context of composable functions..//
  //var count by remember { mutableIntStateOf(0) }

  // remember saveable is used to cache the value when screen rotates..//
  var items by rememberSaveable {
    mutableStateOf(listOf(
      "Item"
    )
    )
  }

  Column (
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ){

    Button(onClick = {
   onCounterButtonClick.invoke()
    }) {
      Text("Count is $counter")
    }
    Button(onClick = {
     items += "item"
    }) {
      Text("Add Item..")
    }
    Text(text = items.toString(),
     modifier = modifier.align(Alignment.CenterHorizontally)

    )
  }
}


@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
private fun StatePracticePreview() {
  SampleComposeAppTheme {
    StatePractice(counter = 0, {})
  }
}