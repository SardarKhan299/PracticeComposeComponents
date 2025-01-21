package com.example.samplecomposeapp.ui_practice.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.samplecomposeapp.ui_practice.navigation.HOME_ROUTE
import com.example.samplecomposeapp.ui_practice.navigation.ROOT_ROUTE

@Composable
fun SetupNavGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = HOME_ROUTE,
    route = ROOT_ROUTE
  ) {
    homeNavGraph(navController)
    authNavGraph(navController)
  }


}