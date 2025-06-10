package com.example.samplecomposeapp.Animation

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun InfiniteAnimations(modifier: Modifier = Modifier) {
 val transition = rememberInfiniteTransition(
  label = "Infinite Transition"
 )
  val ration by transition.animateFloat(
    initialValue = 0f,
    targetValue = 1f,
    animationSpec = InfiniteRepeatableSpec(
      animation = tween(durationMillis = 3000),
      repeatMode = RepeatMode.Reverse
    ),
    label = "Ratio Animation"
  )

  Box(modifier = Modifier
    .graphicsLayer {
      rotationZ = ration * 360f
      scaleX = ration
      scaleY = ration
    }
    .size(100.dp)
    .background(Color.Red)
    .drawBehind {
      drawRect(
        color = Color.Red
      )
    }

  )



}

@Preview(showBackground = true)
@Composable
private fun InfiniteAnimationsPreview() {
  SampleComposeAppTheme {
    InfiniteAnimations()
  }
}