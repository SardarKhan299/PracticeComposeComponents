package com.example.samplecomposeapp.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun SideEffectDemo(modifier: Modifier = Modifier) {
  var counter by remember {
    mutableIntStateOf(0)
  }
  var snackBarHostState = remember {
    SnackbarHostState()
  }
  val scope = rememberCoroutineScope()

  LaunchedEffect(key1 = counter) {
    if (counter % 2 == 0) {
      snackBarHostState.showSnackbar("Counter is even number")
    }
  }

  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    snackbarHost = {
      SnackbarHost(
        hostState = snackBarHostState
      )
    }
  ) { innerPadding->
    Button(
      onClick = {
        counter++
        // USE THIS to test coroutine scope...//
//        if(counter % 2 ==0){
//          scope.launch {
//            snackBarHostState.showSnackbar("Counter is even number")
//          }
//        }
      },
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .wrapContentSize()
    ) {
      Text(
        text = "Counter: $counter"
      )
    }
  }

}

@Preview
@Composable
private fun SideEffectDemoPrev() {
  SampleComposeAppTheme {
    SideEffectDemo()
  }
}