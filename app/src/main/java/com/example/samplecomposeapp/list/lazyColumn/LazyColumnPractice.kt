package com.example.samplecomposeapp.list.lazyColumn

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnPractice(modifier: Modifier = Modifier) {
  LazyColumn (
    modifier = Modifier.fillMaxSize()
  ){
    items(100){ i->
      Text("item $i")
    }

    stickyHeader {
      Text(text = "Sticky Header..",
        modifier = Modifier.fillMaxSize()
          .background(Color.Green)
      )
    }
    items(100){ i->
      Text("item $i")
    }

    stickyHeader {
      Text(text = "Sticky Header..",
        modifier = Modifier.fillMaxSize()
          .background(Color.Green)
      )
    }
    items(100){ i->
      Text("item $i")
    }
    // last Item in List..//
    item {
      Text(
        text = "Footer Reached the End...",
        modifier = Modifier.fillMaxSize()
          .background(Color.Red)
      )
    }



  }
}

@Preview(showBackground = true)
@Composable
private fun LazyColumnPracticePreview() {
  SampleComposeAppTheme {
    LazyColumnPractice()
  }
}