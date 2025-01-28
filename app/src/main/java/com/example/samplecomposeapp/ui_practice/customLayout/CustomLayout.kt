package com.example.samplecomposeapp.ui_practice.customLayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.CustomText
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun CustomLayout(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
private fun CustomLayoutPrev() {
  SampleComposeAppTheme {
    CustomLayout()
  }
}