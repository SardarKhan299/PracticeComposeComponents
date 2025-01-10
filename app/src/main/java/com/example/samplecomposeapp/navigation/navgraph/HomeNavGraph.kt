package com.example.samplecomposeapp.navigation.navgraph

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.samplecomposeapp.navigation.DETAIL_ARGUMENT_KEY
import com.example.samplecomposeapp.navigation.DETAIL_ARGUMENT_KEY2
import com.example.samplecomposeapp.navigation.HOME_ROUTE
import com.example.samplecomposeapp.navigation.Screen
import com.example.samplecomposeapp.navigation.screens.DetailScreen
import com.example.samplecomposeapp.navigation.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController){
  // Home Navigation Graph...//
  navigation(
    startDestination = Screen.Home.route,
    route = HOME_ROUTE
  ) {
    composable(
      route = Screen.Home.route
    ) {
      HomeScreen(navController)
    }

    composable(
      route = Screen.Detail.route,
      arguments = listOf(
        navArgument(DETAIL_ARGUMENT_KEY){
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