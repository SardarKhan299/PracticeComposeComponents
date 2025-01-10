package com.example.samplecomposeapp.windowSizeClass

import android.view.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.samplecomposeapp.layouts.ScaffoldPractice
import com.example.samplecomposeapp.navigation.screens.HomeScreen
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun WindowSizeClassDemo() {
  val windowClass = currentWindowAdaptiveInfo().windowSizeClass
  when(windowClass.windowWidthSizeClass){

  }
    Scaffold { innerPadding->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(innerPadding)
      ){
        when(windowClass.windowWidthSizeClass){
          WindowWidthSizeClass.COMPACT ->{
            Text(text = "Compat")
          }
          WindowWidthSizeClass.MEDIUM ->{
            Text(text = "Medium")
          }
          WindowWidthSizeClass.EXPANDED ->{
            Text(text = "Expanded")
          }
        }
      }
    }

}

@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
private fun WindowSizeClassPreview() {
  SampleComposeAppTheme {
    WindowSizeClassDemo()
  }
}