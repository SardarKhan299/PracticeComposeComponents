package com.example.samplecomposeapp.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import kotlinx.coroutines.delay

@Composable
fun ProduceStateDemo(modifier: Modifier = Modifier) {

//  var counter by remember {
//    mutableIntStateOf(0)
//  }

  // using produce State..//
  val counter by produceState(0) {
    while (true) {
      delay(1000)
      value+=1
    }
  }



  // it will trigger once..
//  LaunchedEffect(true) {
//    // it will update the counter endlessly..//
//    while (true){
//      delay(1000)
//      counter++
//    }
//  }

  Text(
    text = counter.toString(),
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize()
  )
}

@Preview(showBackground = true)
@Composable
private fun ProduceStateDemoPrev() {
  SampleComposeAppTheme {
    ProduceStateDemo()
  }
}