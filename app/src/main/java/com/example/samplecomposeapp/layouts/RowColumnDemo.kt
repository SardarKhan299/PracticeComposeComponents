package com.example.samplecomposeapp.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {

//  Column (modifier = Modifier.fillMaxSize()){
//    Text("Item 1", color = Color.White)
//    HorizontalDivider(color = Color.Blue)
//    Text("Item 2", color = Color.White)
//  }

  // Row practice...//
//  Row (
//    modifier = Modifier.fillMaxSize(),
//    verticalAlignment = Alignment.CenterVertically,
//    horizontalArrangement = Arrangement.spacedBy(
//      space = 20.dp, alignment = Alignment.CenterHorizontally)
//    ){
//    Box(
//      modifier = Modifier.size(100.dp)
//        .background(Color.Red)
//    )
//    Box(
//      modifier = Modifier.size(100.dp)
//        .background(Color.Blue)
//        .align(Alignment.Bottom)
//    )
//    Box(
//      modifier = Modifier.size(100.dp)
//        .background(Color.Green)
//    )
//  }

  Row (
    modifier = Modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(
      space = 20.dp, alignment = Alignment.CenterHorizontally)
  ){
    Text(
      text = "Hello World",
      fontSize = 40.sp,
      color = Color.Blue,
      modifier = Modifier
        .width(120.dp)
        .alignBy(LastBaseline)
    )
    Text(text = "Hello World 1..",
      fontSize = 20.sp,
      color = Color.Red,
      modifier = Modifier.alignByBaseline()

      )
  }
}

@Preview(showBackground = true,
        backgroundColor = 0xff)
@Composable
private fun RowColumnPreview() {
  SampleComposeAppTheme {
    RowColumnDemo()
  }
}