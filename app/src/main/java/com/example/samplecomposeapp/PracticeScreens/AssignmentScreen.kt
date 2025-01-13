package com.example.samplecomposeapp.PracticeScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.samplecomposeapp.textField.CharacterCountComposable
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun AssignmentScreen(modifier: Modifier = Modifier) {
  
}

@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
fun AssignmentScreenPreview() {
  SampleComposeAppTheme {
    AssignmentScreen()
  }
}