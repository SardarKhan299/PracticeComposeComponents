package com.example.samplecomposeapp.ui_practice.compositionLocal

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun CompositionLocalDemo(modifier: Modifier = Modifier) {
  val contentColor = LocalContentColor.current
  val textStyle = LocalTextStyle.current

  Button(
    onClick = {},
    colors = ButtonDefaults.buttonColors(
      contentColor = Color.Red,
      containerColor = Color.Yellow
    )
  ) {
    // this will override the content color...//
    CompositionLocalProvider(
      LocalContentColor provides Color.Green
    ) {
      val contentColor = LocalContentColor.current

      Icon(
        imageVector = Icons.Default.Check,
        contentDescription = null
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(text = "Press Me!")
    }

  }
}

@Preview
@Composable
private fun CompositionLocalDemoPrev() {
  SampleComposeAppTheme {
    CompositionLocalDemo()
  }
}