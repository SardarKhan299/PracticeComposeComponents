package com.example.samplecomposeapp.list

import android.util.Log
import android.view.Display.Mode
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun ListPractice2(){
  var name by remember {
    mutableStateOf("")
  }

  var names by remember {
    mutableStateOf(listOf(""))
  }

  Column (
    modifier = Modifier
    .fillMaxSize()
      .padding(16.dp)
  ) {

    Row(
      modifier = Modifier.fillMaxWidth()
    ) {
      OutlinedTextField(
        value = name,
        onValueChange = { text->
          name = text
        },
        modifier = Modifier.weight(1f)
      )

      Spacer(modifier = Modifier.width(16.dp))

      Button(onClick = {
        if(name.isNotEmpty())
          names = names + name
          name = ""
      }) {
        Text(text = "Add")
      }

    }

    LazyColumn {
      items(names){ currentName->
        Text(text = currentName,
          modifier = Modifier.fillMaxWidth()
            .padding(16.dp))
        HorizontalDivider()
      }

    }

  }




}

@Composable
fun StatePractice(){
  Log.d("ListPractice", ": State Practice ");
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    var count by remember { mutableIntStateOf(0) }
    Log.d("ListPractice", ": Text Recomposing ");
    Text(text = count.toString(),
      fontSize = 30.sp)
    Button(onClick = {
      Log.d("ListPractice", ": Button Click.. ");
      count++
    }) {
      Log.d("ListPractice", ":Button Text recomposition ");
      Text(text = "Click Me $count")
    }

  }
}



@Preview(showBackground = true)
@Composable
fun ListPracticePreview(){
  SampleComposeAppTheme {
    //ListPractice()
    //StatePractice()
    ListPractice2()
  }
}