package com.example.samplecomposeapp.Animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun AnimatedContentDemo(modifier: Modifier = Modifier) {
  var toggle by remember {
    mutableStateOf(false)
  }

  Column(
    modifier = modifier.fillMaxSize()
  ) {
    Button(
      onClick = {
        toggle = !toggle
      }
    ) {
      Text(text = "Toggle")
    }

    val easing = FastOutSlowInEasing
    AnimatedContent (
      targetState = toggle,
      transitionSpec = {
        (slideIntoContainer(
          towards = if(toggle){
            AnimatedContentTransitionScope.SlideDirection.Right
          }else {
            AnimatedContentTransitionScope.SlideDirection.Left
                },
          animationSpec = tween(3000)
        )) togetherWith slideOutOfContainer(
          towards = if(toggle){
            AnimatedContentTransitionScope.SlideDirection.Right
          }else {
            AnimatedContentTransitionScope.SlideDirection.Left
          },
          animationSpec = tween(3000)
        )
      }
    ) { toggle->
      if(toggle) {
        Text(
          text = "Hello, World!",
          modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .border(
              width = 5.dp,
              color = Color.Red
            )
            .wrapContentSize()
        )
      }else{
        Text(
          text = "Hello Compose! This is a sample text",
          modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .border(
              width = 5.dp,
              color = Color.Green
            )
            .wrapContentSize()
        )
      }
    }

    Text("Hi i am Below this Animated Text")

  }
}

@Preview(
  showBackground = true
)
@Composable
private fun AnimatedContentDemoPrev() {
  SampleComposeAppTheme {
    AnimatedContentDemo()
  }
}