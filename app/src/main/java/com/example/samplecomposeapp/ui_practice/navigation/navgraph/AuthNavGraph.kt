package com.example.samplecomposeapp.ui_practice.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.samplecomposeapp.ui_practice.navigation.AUTHENTICATION_ROUTE
import com.example.samplecomposeapp.ui_practice.navigation.Screen
import com.example.samplecomposeapp.ui_practice.navigation.screens.LoginScreen
import com.example.samplecomposeapp.ui_practice.navigation.screens.SignUpScreen


// Auth Navigation Graph...//
fun NavGraphBuilder.authNavGraph(navController: NavHostController){
  navigation(
    startDestination = Screen.Login.route,
    route = AUTHENTICATION_ROUTE
  ){
    composable(
      route = Screen.Login.route
    ) {
      LoginScreen(navController)
    }

    composable(
      route = Screen.SignUp.route
    ) {
      SignUpScreen(navController)
    }
  }
}