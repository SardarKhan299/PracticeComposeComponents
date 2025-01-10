package com.example.samplecomposeapp.navigation.screens

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.samplecomposeapp.navigation.AUTHENTICATION_ROUTE
import com.example.samplecomposeapp.navigation.HOME_ROUTE
import com.example.samplecomposeapp.navigation.Screen


@Composable
fun LoginScreen(navController: NavController) {

  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ){
    Text(
      modifier = Modifier.clickable {
        navController.navigate(route = Screen.SignUp.route)
      },
      text = "Login Screen",
      color = MaterialTheme.colorScheme.primary,
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold
    )

    Text(
      modifier = Modifier
        .padding(top = 150.dp)
        .clickable {
          navController.navigate(HOME_ROUTE){
            popUpTo(HOME_ROUTE)
          }
        },
      text = "Back",
      color = MaterialTheme.colorScheme.primary,
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold
    )
  }
  
}