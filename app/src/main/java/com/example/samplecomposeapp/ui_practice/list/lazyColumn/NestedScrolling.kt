package com.example.samplecomposeapp.ui_practice.list.lazyColumn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun NestedScrolling(modifier: Modifier = Modifier) {

  LazyColumn (
    modifier = Modifier.fillMaxSize()
  ){
    items(20){
      Text(
        text = "Item $it",
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      )
    }
    item{
      LazyColumn (
        modifier = Modifier
          .fillMaxWidth()
          .height(400.dp)
      ){
        items(10){
          Text(
            text = "Another Item $it",
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp)
          )
        }
      }

    }
  }

}

@Preview(showBackground = true)
@Composable
private fun NestedScrollingPrev() {
  SampleComposeAppTheme {
    NestedScrolling()
  }
}