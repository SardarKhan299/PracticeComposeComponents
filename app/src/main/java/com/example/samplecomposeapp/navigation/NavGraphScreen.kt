package com.example.samplecomposeapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = Screen.Home.route
  ) {
    composable(
      route = Screen.Home.route
    ) {
      HomeScreen(navController)
    }

    composable(
      route = Screen.Detail.route,
      arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY){
        type = NavType.IntType
      },
        navArgument(DETAIL_ARGUMENT_KEY2){
          type = NavType.StringType
        }
        )
    ) {
      Log.d("navgraph", "Args id :${it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString()} ")
      Log.d("navgraph", "Args Name:${it.arguments?.getString(DETAIL_ARGUMENT_KEY2)} ")
      DetailScreen(navController)
    }
  }
}