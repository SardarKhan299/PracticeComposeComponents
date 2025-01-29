package com.example.samplecomposeapp.ui_practice.customLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.CustomText
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun CustomLayout(
  page:Int,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
  ) {
  Layout(
    content = content,
    modifier = modifier
  ){
    measurables, constraints ->
    val placeable = measurables.map {
      it.measure(constraints)
    }

    layout(constraints.maxWidth,constraints.maxHeight){
      var xOffset = 0
      placeable.forEach { placeable->
        placeable.place(xOffset,0)
        xOffset += placeable.width
      }
    }


  }
}

@Preview(showBackground = true)
@Composable
private fun CustomLayoutPrev() {
  SampleComposeAppTheme {
    CustomLayout(
      page = 0
    ){
      Box(
        modifier = Modifier
          .width(150.dp)
          .height(100.dp)
          .background(Color.Red)
      )
      Box(
        modifier = Modifier
          .width(50.dp)
          .height(100.dp)
          .background(Color.Yellow)
      )
      Box(
        modifier = Modifier
          .width(75.dp)
          .height(100.dp)
          .background(Color.Green)
      )
      Box(
        modifier = Modifier
          .width(300.dp)
          .height(100.dp)
          .background(Color.Blue)
      )
    }
  }
}