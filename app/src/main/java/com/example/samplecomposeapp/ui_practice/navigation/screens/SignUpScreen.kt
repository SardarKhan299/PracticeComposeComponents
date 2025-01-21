package com.example.samplecomposeapp.ui_practice.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController) {

  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ){
    Text(
      modifier = Modifier.clickable {
        navController.popBackStack()
      },
      text = "SignUp Screen",
      color = MaterialTheme.colorScheme.primary,
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold
    )
  }
  
}