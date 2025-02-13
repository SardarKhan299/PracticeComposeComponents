package com.example.samplecomposeapp.side_effect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import kotlinx.coroutines.delay


//@Composable
//fun LaunchAnimation(modifier: Modifier = Modifier,
//                    snakbarHostState: SnackbarHostState,
//                    username: String) {
//  LaunchedEffect(username) {
//    delay(5000L)
//    snakbarHostState.showSnackbar("Welcome $username")
//  }
//}

// Fixed the issue with RememberUpdate State

@Composable
fun LaunchAnimation(modifier: Modifier = Modifier,
                    snakbarHostState: SnackbarHostState,
                    username: String) {
  // this will only update the username just one time...//
  val updatedUsername by rememberUpdatedState(newValue = username)
  LaunchedEffect(true) {
    delay(5000L)
    snakbarHostState.showSnackbar("Welcome $updatedUsername")
  }
}


@Composable
fun RememberUpdateStatePractice(modifier: Modifier = Modifier) {
  var username by remember {
    mutableStateOf("")
  }

  val snackbarHostState = remember {
    SnackbarHostState()
  }

  Scaffold (
    modifier = Modifier
      .fillMaxSize(),
    snackbarHost = { SnackbarHost(snackbarHostState) }
  ){
    innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {

      LaunchAnimation(
        snakbarHostState = snackbarHostState,
        username = username
      )
      TextField(
        value = username,
        onValueChange = {
          username = it
        },
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth()
          .background(Color.LightGray),
        placeholder = {
          Text(" Enter username... ")
        }
      )
    }
  }

}

@PreviewLightDark
@Preview(showBackground = true)
@Composable
private fun RememberUpdateStatePracticePrev() {
  SampleComposeAppTheme {
    RememberUpdateStatePractice()
  }
}