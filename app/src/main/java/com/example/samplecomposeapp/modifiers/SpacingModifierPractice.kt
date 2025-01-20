package com.example.samplecomposeapp.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SpacingModifierPractice(modifier: Modifier = Modifier) {

  Column (
    modifier = modifier
      .safeDrawingPadding()
      .fillMaxSize()
  ){

    LazyColumn(
      modifier = Modifier.fillMaxWidth()
        .weight(1f)
        .imeNestedScroll()
    ) {
      items(100){
        Text(
          text = "Testing Text $it"
        )
        Spacer(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        )
      }
    }
    TextField(
      value = "",
      onValueChange = {}
    )

  }
}


@Preview
@Composable
private fun SpacingModifierPracticePrev() {
  SampleComposeAppTheme {
    SpacingModifierPractice()
  }
}