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
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastMaxOfOrNull
import com.example.samplecomposeapp.CustomText
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun SubComposeCustomLayout(
  page:Int,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
  ) {
  SubcomposeLayout (
    modifier = modifier
  ){
    constraints ->

    val pages = mutableListOf<List<Placeable>>()
    var currentPage = mutableListOf<Placeable>()
    var currentPageWidth = 0

    val measurables = subcompose("content",content)

    var i = 0

    for(measurable in measurables){
      val placeable = measurable.measure(constraints)
      if(currentPageWidth + placeable.width > constraints.maxWidth){
        if(pages.size == page){
          break
        }
        pages.add(currentPage)
        currentPage = mutableListOf()
        currentPageWidth = 0
      }
      currentPage.add(placeable)
      currentPageWidth += placeable.width
    }

    println("We measured $i composables")

    if(currentPage.isNotEmpty()){
      pages.add(currentPage)
    }


    val pageItems = pages.getOrNull(page) ?: emptyList()
    val maxheight = pageItems.fastMaxOfOrNull { it.height } ?: 0

    layout(constraints.maxWidth,constraints.maxHeight){
      var xOffset = 0
      pageItems.forEach { placeable->
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
    SubComposeCustomLayout(
      page = 0
    ){
      Box(
        modifier = Modifier
          .width(300.dp)
          .height(100.dp)
          .background(Color.Red)
      )
      Box(
        modifier = Modifier
          .width(80.dp)
          .height(100.dp)
          .background(Color.Yellow)
      )
      Box(
        modifier = Modifier
          .width(120.dp)
          .height(100.dp)
          .background(Color.Green)
      )
      Box(
        modifier = Modifier
          .width(200.dp)
          .height(100.dp)
          .background(Color.Blue)
      )
    }
  }
}