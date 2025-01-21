package com.example.samplecomposeapp.ui_practice.layouts

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPractice() {

  val snackBarState = remember {
    SnackbarHostState()
  }

  val scope = rememberCoroutineScope()
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(text = "Hello World Top Bar...")
        },
        navigationIcon = {
          IconButton(onClick = {}) {
            Icon (imageVector = Icons.AutoMirrored.Default.ArrowBack,
              contentDescription = "Go Back...."
            )
          }
        },
        actions = {
          IconButton(onClick = {}) {
          }
        }
      )
    },
    bottomBar =  {
      BottomAppBar {
      NavigationBarItem(
        selected = true,
        onClick = {},
        icon = {
          Icon(imageVector = Icons.Default.Star,
            contentDescription = null)
        },
        label = {
          Text("Favourites")
        }
      )
      NavigationBarItem(
        selected = false,
        onClick = {},
        icon = {
          Icon(imageVector = Icons.Default.Search,
            contentDescription = null)
        },
        label = {
          Text("Search")
        }
      )
    }
},
    floatingActionButton = {
      FloatingActionButton(onClick = {
        Log.d("Scaffold", "Clicked..: ");
        scope.launch {
          snackBarState.showSnackbar("FAB Clicked...")
        }

      }) {
        Icon(imageVector = Icons.Default.Add,
          contentDescription = null)
      }
    },
    snackbarHost = {
      SnackbarHost(
        hostState = snackBarState,
      ) {  }
    }
  ) {
    contentPadding ->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(contentPadding)
          .background(Color.Red)
      ){
        Text(text = "Hello Text Box...",
          fontSize = 16.sp
          )
      }
  }
}

@Preview(showBackground = true,
  backgroundColor = 0xff)
@Composable
private fun ScaffoldPreview() {
  SampleComposeAppTheme {
    ScaffoldPractice()
  }
}