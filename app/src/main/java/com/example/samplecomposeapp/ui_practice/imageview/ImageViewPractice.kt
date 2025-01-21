package com.example.samplecomposeapp.ui_practice.imageview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.R
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun ImageViewPractice() {
  Box(modifier = Modifier
    .size(200.dp)
    .background(Color.Green)
  ) {
    Image(
      painter = painterResource(R.drawable.ic_launcher_foreground),
      contentDescription = null,
      modifier = Modifier
        .size(60.dp)
        .background(Color.Black)
        .align(Alignment.TopEnd)
    )
    Icon(
      imageVector = Icons.Default.Add,
      contentDescription = null,
      modifier = Modifier
        .align(Alignment.BottomStart)
        .background(Color.Red)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
  SampleComposeAppTheme {
    ImageViewPractice()
  }
}