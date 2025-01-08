package com.example.samplecomposeapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ){
    Text(
      text = "Detail",
      color = MaterialTheme.colorScheme.secondary,
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold
    )
  }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
  DetailScreen()
}