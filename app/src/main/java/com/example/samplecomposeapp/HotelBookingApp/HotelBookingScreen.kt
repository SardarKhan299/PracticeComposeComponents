package com.example.samplecomposeapp.HotelBookingApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.R
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
  LazyColumn (
    modifier = modifier
      .fillMaxSize()
      .background(Color.White)
  ){
    item {
      Box {
        Image(painter = painterResource(R.drawable.living_room),
          contentDescription = null)

        HotelFadedBanner(
          modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomStart)
        )

      }
    }
  }
}

@Composable
fun HotelFadedBanner(modifier: Modifier = Modifier) {
  Row (
    modifier = modifier
      .background(
        Color.White.copy(
          alpha = 0.7f
        )
      )
      .padding(16.dp)
  ){
    Column(
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      Text(
        text = "Hotel California Strawberry ",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
      )
      LabeledIcon(
        text = "Los Angelos, California",
        icon = {
          Icon(imageVector = Icons.Default.LocationOn,
            contentDescription = null,
            tint = Color.DarkGray)
        })
      LabeledIcon(
        text = "4.9 (13k reviews) ",
        icon = {
          Icon(imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = Color.Yellow)
        })
    }

  }
}

@Composable
fun LabeledIcon(text:String ,
                icon: @Composable () -> Unit,
                modifier: Modifier = Modifier,
                ) {

  Row (
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {
    icon()
    Spacer(modifier = modifier.padding(2.dp))
    Text(text = text,
      fontSize = 13.sp)
  }

}

@Preview
@Composable
private fun HotelBookingScreenPreview() {
  SampleComposeAppTheme {
    HotelBookingScreen()
  }
}