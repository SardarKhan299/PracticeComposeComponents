package com.example.samplecomposeapp.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {

//  Column (modifier = Modifier.fillMaxSize()){
//    Text("Item 1", color = Color.White)
//    HorizontalDivider(color = Color.Blue)
//    Text("Item 2", color = Color.White)
//  }

  Row (
    modifier = Modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceEvenly
    ){
    Box(
      modifier = Modifier.size(100.dp)
        .background(Color.Red)
    )
    Box(
      modifier = Modifier.size(100.dp)
        .background(Color.Blue)
    )
    Box(
      modifier = Modifier.size(100.dp)
        .background(Color.Green)
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