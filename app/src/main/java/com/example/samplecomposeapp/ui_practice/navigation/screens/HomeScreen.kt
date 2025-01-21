package com.example.samplecomposeapp.ui_practice.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.samplecomposeapp.ui_practice.navigation.AUTHENTICATION_ROUTE
import com.example.samplecomposeapp.ui_practice.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ){
    Text(
      modifier = Modifier.clickable {
        navController.navigate(route = Screen.Detail.passIdAndName(
          id = 1,
          name = "sardar"
        )
        )
      },
      text = "Home",
      color = MaterialTheme.colorScheme.primary,
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold
    )

    Text(
      modifier = Modifier
        .padding(top = 150.dp)
        .clickable {
        navController.navigate(AUTHENTICATION_ROUTE)
      },
      text = "Login/Sign Up",
      color = MaterialTheme.colorScheme.primary,
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold
    )
  }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
  HomeScreen(
    navController = rememberNavController()
  )
}