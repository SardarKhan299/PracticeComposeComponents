package com.example.samplecomposeapp.performance

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ImageLoading(
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize(),
    contentPadding = PaddingValues(16.dp)
  ) {
    items(100) {
      AsyncImage(
        model = "https://cdn.pixabay.com/photo/2012/10/26/09/42/climb-63281_1280.jpg",
        contentDescription = null,
        modifier = Modifier
          .fillParentMaxWidth(),
        contentScale = ContentScale.Crop
      )
    }
  }
}