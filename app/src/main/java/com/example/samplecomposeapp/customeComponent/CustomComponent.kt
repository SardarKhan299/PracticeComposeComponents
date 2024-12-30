package com.example.samplecomposeapp.customeComponent

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.textField.CharacterCountComposable
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun CustomComponent(){

}


@Composable
@Preview
fun CharacterCountComposablePreview() {
  SampleComposeAppTheme {
    CustomComponent()
  }
}