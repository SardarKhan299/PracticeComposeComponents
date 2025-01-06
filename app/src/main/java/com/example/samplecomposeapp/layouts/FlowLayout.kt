package com.example.samplecomposeapp.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayout(modifier: Modifier = Modifier) {

  FlowRow(
    modifier = modifier
      .fillMaxSize()
      .background(Color.Red),
    horizontalArrangement = Arrangement.spacedBy(
      space = 20.dp
    ),
    verticalArrangement = Arrangement.Top,
    maxLines = 4,
    overflow = FlowRowOverflow.expandOrCollapseIndicator(
      expandIndicator = {
        IconButton(onClick = {}) {
          Icon(imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Expand")
        }
      },
      collapseIndicator = {
        IconButton(onClick = {}) {
          Icon(imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = "Expand")
        }
      }
    )
  ) {
    for (i in 1..30) {

      AssistChip(
        onClick = {},
        label = {
          Text(
            text = "Item $i",
            Modifier.background(Color.Green)
          )
        },
        modifier = Modifier.background(color = Color.Blue)
      )
    }

  }
}


@Preview(showBackground = true,
  backgroundColor = 0xff)
@Composable
private fun FlowLayoutPreview() {
  SampleComposeAppTheme {
    FlowLayout()
  }
}


