package com.example.samplecomposeapp.ui_practice.navigation.bottom_nav

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.samplecomposeapp.ui_practice.navigation.bottom_nav.screens.BottomBarScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
  val navController = rememberNavController()

  Scaffold (
    bottomBar = {
      BottomBar(navController)
    }
  ){
    BottomNavGraph(navController)
  }
  
}

@Composable
fun BottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
  val screens = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Profile,
    BottomBarScreen.Settings
  )
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination

  NavigationBar {
    screens.forEachIndexed { index, item ->
      NavigationBarItem(
        icon = { Icon(imageVector = item.icon, contentDescription = null) },
        label = { Text(
          text = item.title
        ) },
        selected =currentDestination?.hierarchy?.any{
          it.route == item.route
        } == true ,
        onClick = {
          navController.navigate(item.route){
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
          }
        }
      )
    }

  }

}