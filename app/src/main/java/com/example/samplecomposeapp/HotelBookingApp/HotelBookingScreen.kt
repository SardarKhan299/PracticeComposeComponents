package com.example.samplecomposeapp.HotelBookingApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.samplecomposeapp.R
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


private val tags = listOf(
  "City Center",
  "Luxury",
  "Instant Booking",
  "Exclusive Deal",
  "Early Bird Discount",
  "Romantic Gateway",
  "Romantic Gateway",
  "24/7 Support"
)

private val offers = mapOf(
  R.drawable.bed to "2 Bed",
  R.drawable.breakfast to "Breakfast",
  R.drawable.cutlery to "Cutlery",
  R.drawable.pawprint to "Pet Friendly",
  R.drawable.serving_dish to "Dinner",
  R.drawable.snowflake to "Air Conditioning",
  R.drawable.television to "TV",
  R.drawable.wi_fi_icon to "Wifi"
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
  LazyColumn (
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ){
    item {
      Box {
        Image(painter = painterResource(R.drawable.living_room),
          contentDescription = null,
          modifier = Modifier.fillMaxWidth()
            .heightIn(
              max = 250.dp
            ),
          contentScale = ContentScale.Crop)

        HotelFadedBanner(
          modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomStart)
        )

      }

    }
    item {
      HorizontalDivider(
        modifier = Modifier.padding(16.dp)
      )
    }
    item {
      FlowRow (modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp,Alignment.CenterHorizontally)) {
        tags.forEach { tag->
          AssistChip(
            onClick = {},
            label = {
              Text(text = tag)
            }
          )
        }
      }
    }

    item {
      HorizontalDivider(
        modifier = Modifier.padding(16.dp)
      )
    }
    item {
     Text(text = """
                    The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.’s best attractions.
                """.trimIndent(),
       fontSize = 13.sp,
       modifier = Modifier.fillMaxWidth()
         .padding(horizontal = 16.dp))
    }

    item {
      Text(
        text = "What we offer",
        fontSize = 18.sp,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
      )
    }
    item {
      LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp,Alignment.CenterHorizontally)) {
        items(offers.entries.toList()){ (drawableResId,label) ->
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
              .background(Color.Gray.copy(alpha = 0.3f))
              .padding(8.dp)
            ){
            Icon(
              imageVector = ImageVector.vectorResource(id = drawableResId),
              contentDescription = label,
              modifier = Modifier.size(36.dp)
            )

            Text(text = label,
              fontSize = 13.sp)
          }

        }
      }
    }
    item{
      Button(
        onClick = {},
        modifier = Modifier
          .padding(horizontal = 16.dp)
          .widthIn(
            max = 600.dp
          )
          .fillMaxWidth()
      ) {
        Text(text = "Book Now!")
      }
    }

  }
}

@Composable
fun HotelFadedBanner(modifier: Modifier = Modifier) {
val windowClass = currentWindowAdaptiveInfo().windowSizeClass


  Row (
    modifier = modifier
      .background(
        Color.White.copy(
          alpha = 0.7f
        )
      )
      .padding(16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Bottom
  ){
    Column(
      verticalArrangement = Arrangement.spacedBy(4.dp),
      modifier = Modifier.weight(1f)
    ) {
      Text(
        text = "Hotel California Strawberry",
        fontWeight = FontWeight.Bold,
        fontSize = when(windowClass.windowWidthSizeClass){
          WindowWidthSizeClass.COMPACT -> 18.sp
          WindowWidthSizeClass.MEDIUM -> 24.sp
          WindowWidthSizeClass.EXPANDED -> 30.sp
          else -> 18.sp

        },
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
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

    Text(text = buildAnnotatedString {
      val fontSizeMultiplier = when(windowClass.windowWidthSizeClass){
        WindowWidthSizeClass.COMPACT -> 1f
        WindowWidthSizeClass.MEDIUM -> 1.2f
        WindowWidthSizeClass.EXPANDED -> 1.5f
        else -> 1f
      }
      withStyle(
        style = SpanStyle(
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp * fontSizeMultiplier,
          color = Color.Black
        )
      ) {
        append("420$/")
      }

      withStyle(
        style = SpanStyle(
          fontWeight = FontWeight.SemiBold,
          fontSize = 14.sp * fontSizeMultiplier,
          color = Color.Black
        )
      ) {
        append("night")
      }
    })

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

@PreviewScreenSizes
@Preview
@Composable
private fun HotelBookingScreenPreview() {
  SampleComposeAppTheme {
    HotelBookingScreen()
  }
}