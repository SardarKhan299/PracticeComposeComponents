package com.example.samplecomposeapp.ui_practice.navigation.bottom_nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.samplecomposeapp.ui_practice.navigation.bottom_nav.screens.BottomBarScreen
import com.example.samplecomposeapp.ui_practice.navigation.bottom_nav.screens.HomeScreen
import com.example.samplecomposeapp.ui_practice.navigation.bottom_nav.screens.ProfileScreen
import com.example.samplecomposeapp.ui_practice.navigation.bottom_nav.screens.SettingScreen


@Composable
fun BottomNavGraph(navHostController: NavHostController, modifier: Modifier = Modifier) {

  NavHost(
    navController = navHostController,
    startDestination = BottomBarScreen.Home.route
  ){
   composable(route = BottomBarScreen.Home.route){
     HomeScreen()
   }
    composable(route = BottomBarScreen.Profile.route){
      ProfileScreen()
    }
    composable(route = BottomBarScreen.Settings.route){
      SettingScreen()
    }
  }
}