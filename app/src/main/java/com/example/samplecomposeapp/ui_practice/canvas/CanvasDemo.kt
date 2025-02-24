package com.example.samplecomposeapp.ui_practice.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun CanvasDemo(modifier: Modifier = Modifier) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Green)
      .drawBehind {
        withTransform(
          transformBlock = {
            rotate(
              degrees = 45f,
              pivot = center
            )
          },
          drawBlock = {
            drawLine(
              brush = Brush.verticalGradient(
                colors = listOf(Color.Red, Color.Blue)
              ),
              start = Offset.Zero,
              end = center,
              strokeWidth = 8.dp.toPx()
            )
          }
        )
        drawCircle(
          color = Color.Red
        )

      },
    contentAlignment = Alignment.Center
  ) {
    Text("Hello World...")
  }
}

@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun CanvasDemoPrev() {
  SampleComposeAppTheme {
    CanvasDemo()
  }
}