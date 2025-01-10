package com.example.samplecomposeapp.layouts

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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPractice() {

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
      FloatingActionButton(onClick = {}) {
        Icon(imageVector = Icons.Default.Add,
          contentDescription = null)
      }
    }
  ) {

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