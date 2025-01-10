package com.example.samplecomposeapp.windowSizeClass

import android.view.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
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
            MyLazyList()
          }
          WindowWidthSizeClass.MEDIUM ->{
            Text(text = "Medium")
            MyLazyList()
          }
          WindowWidthSizeClass.EXPANDED ->{
            Text(text = "Expanded")
            Row (modifier = Modifier.fillMaxSize()) {
              Column(
                modifier = Modifier.fillMaxHeight()
                  .weight(2f)
                  .background(Color.Red)
              ) {
                Text(text = "Menu Option 1")
                Text(text = "Menu Option 2")
                Text(text = "Menu Option 3")
              }
              MyLazyList(modifier = Modifier
                .fillMaxHeight()
                .weight(6f))

              Column(
                modifier = Modifier.fillMaxHeight()
                  .weight(2f)
                  .background(Color.Blue)
              ) {
                Text(text = "Menu Option 1")
                Text(text = "Menu Option 2")
                Text(text = "Menu Option 3")
              }
            }
          }
        }
      }
    }

}


@Composable
fun MyLazyList(modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier.fillMaxSize()){
    items(100){
      Text(text = "Item $it",
        modifier = Modifier.padding(16.dp))
    }
  }
}

@PreviewScreenSizes
@Preview(showBackground = true,
  widthDp = 1000,
  device = Devices.NEXUS_7)
@Composable
private fun WindowSizeClassPreview() {
  SampleComposeAppTheme {
    WindowSizeClassDemo()
  }
}