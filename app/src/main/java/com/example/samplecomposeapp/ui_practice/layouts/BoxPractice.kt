package com.example.samplecomposeapp.ui_practice.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.R
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun BoxPractice(modifier: Modifier = Modifier) {
  Box(
    modifier = Modifier.fillMaxSize()
      .background(Color.Black),
    contentAlignment = Alignment.BottomCenter
  ) {

    Image(
      painter = painterResource(R.drawable.ic_launcher_foreground),
      contentDescription = null,
      Modifier.background(color = Color.White)
    )

    Box(
      modifier = Modifier
        .matchParentSize()
        .background(
          brush = Brush.verticalGradient(
            colors = listOf(
              Color.Transparent,
              Color.LightGray
            )
          )
        )
    ){

    }

    IconButton(onClick = {},
      modifier = Modifier.align(Alignment.BottomEnd)) {
      Icon(
        imageVector = Icons.Default.Star,
        contentDescription = null,
        tint = Color.Blue
      )
    }

    Text(
      text = "Hello World..",
      color = Color.Blue,
      modifier = Modifier.align(Alignment.TopStart)
    )
    Text(
      text = "Hi How are you..",
      color = Color.Red,
      modifier = Modifier.align(Alignment.BottomStart)
    )

  }
}

@Preview(showBackground = true,
  backgroundColor = 0xff)
@Composable
private fun RowColumnPreview() {
  SampleComposeAppTheme {
    BoxPractice()
  }
}