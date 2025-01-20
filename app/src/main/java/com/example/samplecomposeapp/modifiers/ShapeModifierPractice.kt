package com.example.samplecomposeapp.modifiers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.copy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.R
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import java.lang.StrictMath.tan
import kotlin.math.PI

fun Int.toRadian() = this * PI / 180

@Composable
fun ShapeModifierPractice(modifier: Modifier = Modifier) {

  // First image...//
//  Image(
//    painter = painterResource(R.drawable.android),
//    contentDescription = null,
//    modifier = Modifier
//      .size(200.dp)
//      .clip(CircleShape)
//      .background(Color.Red)
//      .padding(8.dp)
//  )



  // Second Image..//
//  Image(
//    painter = painterResource(R.drawable.android),
//    contentDescription = null,
//    modifier = Modifier
//      .size(200.dp)
//      .clip(RoundedCornerShape(
//        topStartPercent = 50,
//        topEndPercent = 20,
//        bottomEndPercent = 20,
//        bottomStartPercent = 20
//      ))
//      .background(Color.Red)
//      .padding(8.dp)
//  )

  // Third Image..//
  Image(
    painter = painterResource(R.drawable.android),
    contentDescription = null,
    modifier = Modifier
      .size(200.dp)
      .clip(StarShape)
      .background(Color.Red)
      .padding(8.dp)
  )

}

data object TriangleShape: Shape {

  override fun createOutline(
    size: Size,
    layoutDirection: LayoutDirection,
    density: Density
  ): Outline {
   return Outline.Generic(
     path = Path().apply {
       moveTo(
         x = size.width / 2f,
         y= 0f
       )
       lineTo(
         x = 0f,
         y = size.height
       )
       lineTo(
         x = size.width,
         y = size.height
       )
       close()
     }
   )
  }

}

object StarShape : Shape {
  override fun createOutline(
    size: Size,
    layoutDirection: LayoutDirection,
    density: Density
  ): Outline {

    val width = size.width
    val height = size.height

    val pointOne = Pair(width / 2, 0f)
    val pointTwo = Pair((width / 2) - (height * tan(18.toRadian())), height)
    val pointThree = Pair(width, height - ((width + 2 * height * tan(18.toRadian())) / (2 * tan(54.toRadian()))))
    val pointFour = Pair(0f, height - ((width + 2 * height * tan(18.toRadian())) / (2 * tan(54.toRadian()))))
    val pointFive = Pair((width / 2 + height * tan(18.toRadian())), height)

    return Outline.Generic(
      path = Path().apply {
        moveTo(
          x = pointOne.first,
          y = pointOne.second
        )
        lineTo(
          x = pointTwo.first.toFloat(),
          y = pointTwo.second
        )
        lineTo(
          x = pointThree.first,
          y = pointThree.second.toFloat()
        )
        lineTo(
          x = pointFour.first.toFloat(),
          y = pointFour.second.toFloat()
        )
        lineTo(
          x = pointFive.first.toFloat(),
          y = pointFive.second
        )
        close()
      }
    )
  }
}

@Preview
@Composable
private fun ShapeModifierPracticePrev() {
  SampleComposeAppTheme {
    ShapeModifierPractice()
  }
}