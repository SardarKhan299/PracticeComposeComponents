package com.example.samplecomposeapp.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun DisposableEffectDemo(modifier: Modifier = Modifier) {
  val lifecycleOwner = LocalLifecycleOwner.current
  DisposableEffect(lifecycleOwner.lifecycle) {

    val observer = LifecycleEventObserver { _, event ->
      when (event) {
        Lifecycle.Event.ON_START ->{
          println("On Start was called...")
        }
        else -> Unit
      }
    }
    lifecycleOwner.lifecycle.addObserver(observer)

    // this will call when Disposable Effect leaves our composition..//
    // clean up register callbacks..//
    onDispose {
      println("Observer was disposed..")
      lifecycleOwner.lifecycle.removeObserver(observer)
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun DisposableEffectDemoPrev() {
  SampleComposeAppTheme {
    DisposableEffectDemo()
  }
}