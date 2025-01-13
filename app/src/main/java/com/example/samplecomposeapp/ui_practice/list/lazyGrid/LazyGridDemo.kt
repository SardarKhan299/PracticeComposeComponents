package com.example.samplecomposeapp.ui_practice.list.lazyGrid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import kotlin.random.Random
import kotlin.random.nextInt


@Composable
fun LazyGridDemo() {
//  LazyVerticalGrid(
//    columns = GridCells.Adaptive(50.dp),
//    verticalArrangement = Arrangement.spacedBy(16.dp),
//    horizontalArrangement = Arrangement.spacedBy(16.dp),
//    contentPadding = PaddingValues(16.dp)
//  ) {
//    items(100){
//      Box(
//        modifier = Modifier
//          .width(
//            width = Random.nextInt(1..200).dp
//          )
//          .height(100.dp)
//          .background(Color(Random.nextInt()))
//
//      )
//    }
//  }


  // Staggred Grid for Different Height for Cells..//
  LazyVerticalStaggeredGrid(
    columns = StaggeredGridCells.Fixed(5),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    contentPadding = PaddingValues(16.dp)
  ) {
    items(100){
      Box(
        modifier = Modifier
          .height(
            height = Random.nextInt(1..200).dp
          )
          .clip(RoundedCornerShape(8.dp))
          .background(Color(Random.nextInt()))

      )
    }
  }

}


@Preview
@Composable
private fun LazyGridPrev() {
  SampleComposeAppTheme {
    LazyGridDemo()
  }
}