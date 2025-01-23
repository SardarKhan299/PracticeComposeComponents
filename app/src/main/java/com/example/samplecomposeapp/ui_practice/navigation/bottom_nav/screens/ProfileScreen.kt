package com.example.samplecomposeapp.ui_practice.navigation.bottom_nav.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
  Box(
    modifier = Modifier.fillMaxSize()
      .background(Color.Red),
    contentAlignment = Alignment.Center
  ){
    Text(
      text = "Profile Screen",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White
    )
  }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
  SampleComposeAppTheme {
    ProfileScreen()
  }
}