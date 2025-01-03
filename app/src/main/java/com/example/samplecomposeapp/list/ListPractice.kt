package com.example.samplecomposeapp.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.textField.TextFieldCompose
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun ListPractice(){
  LazyColumn(modifier = Modifier.fillMaxSize()) {
    items(100){
      Icon(
        imageVector = Icons.Default.Add,
        contentDescription = null,
        modifier = Modifier.size(30.dp)
      )

    }

  }

}



@Preview(showBackground = true)
@Composable
fun ListPracticePreview(){
  SampleComposeAppTheme {
    ListPractice()
  }
}