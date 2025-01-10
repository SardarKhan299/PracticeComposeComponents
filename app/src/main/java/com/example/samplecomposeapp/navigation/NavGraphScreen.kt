package com.example.samplecomposeapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.samplecomposeapp.navigation.screens.DetailScreen
import com.example.samplecomposeapp.navigation.screens.HomeScreen
import com.example.samplecomposeapp.navigation.screens.LoginScreen
import com.example.samplecomposeapp.navigation.screens.SignUpScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = Screen.Home.route
  ) {


    navigation(
      startDestination = Screen.Login.route,
      route = ROOT_ROUTE
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


}