package com.example.samplecomposeapp.customeComponent

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.samplecomposeapp.textField.CharacterCountComposable
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun CustomComponent(canvasSize: Dp = 300.dp,
                    indicatorValue: Int = 0,
                    maxIndicatorValue : Int = 100,
                    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f),
                    backgroundIndicatorStrokeWidth: Float = 100f,
                    foregroundIndicatorColor: Color = Color.Green,
                    foregroundIndicatorStrokeWidth: Float = 100f,
                    bigTextFontSize: TextUnit = MaterialTheme.typography.labelLarge.fontSize,
                    bigTextColor: Color = MaterialTheme.colorScheme.onSurface,
                    bigTextSuffix: String = "GB",
                    smallText: String = "Remaining",
                    smallTextFontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
                    smallTextColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                    smallTextSuffix: String = "GB"
                    ){

  var allowedIndicatorValue by remember {
    mutableStateOf(maxIndicatorValue)
  }

  allowedIndicatorValue = if(indicatorValue <= maxIndicatorValue){
    indicatorValue
  }else {
    maxIndicatorValue
  }

  var animatedIndicatorValue by remember { mutableStateOf(0) }
  LaunchedEffect(key1 = allowedIndicatorValue) {
    animatedIndicatorValue = allowedIndicatorValue
  }


  
  val percentage = animatedIndicatorValue / maxIndicatorValue * 100
  val sweepAngle by animateFloatAsState(
    targetValue = (2.4 * percentage ).toFloat(),
    animationSpec = tween(1000)
  )

  val receivedValue by animateIntAsState(
    targetValue = allowedIndicatorValue,
    animationSpec = tween(1000)
  )

  Column(modifier = Modifier
    .size(canvasSize)
    .drawBehind {
      val componentSize = size / 1.25f
      backgroundIndicator(
        componentSize,
        indicatorColor = backgroundIndicatorColor,
        indicatorStrokeWidth = backgroundIndicatorStrokeWidth
      )
      foregroundIndicator(
        sweepAngle = sweepAngle,
        componentSize = componentSize,
        indicatorColor = foregroundIndicatorColor,
        indicatorStrokeWidth = foregroundIndicatorStrokeWidth
      )
    },
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    EmbeddedElements(
      bigText = receivedValue.toString(),
      bigTextColor = bigTextColor,
      bigTextSuffix = bigTextSuffix,
      bigTextFontSize = bigTextFontSize,
      smallText = smallText,
      smallTextColor = smallTextColor,
      smallTextFontSize = smallTextFontSize,
    )
  }





}


fun DrawScope.backgroundIndicator(
  componentSize: Size,
  indicatorColor: Color,
  indicatorStrokeWidth: Float
){
  drawArc(
    color = indicatorColor,
    startAngle = 150f,
    sweepAngle = 240f,
    useCenter = false,
    style = Stroke(
      width = indicatorStrokeWidth,
      cap = StrokeCap.Round
    ),
    topLeft = Offset(
      x = (size.width - componentSize.width)/2,
      y = (size.height - componentSize.height) /2f
    )
  )
}

fun DrawScope.foregroundIndicator(
  sweepAngle: Float,
  componentSize: Size,
  indicatorColor: Color,
  indicatorStrokeWidth: Float
){
  drawArc(
    color = indicatorColor,
    startAngle = 150f,
    sweepAngle = sweepAngle,
    useCenter = false,
    style = Stroke(
      width = indicatorStrokeWidth,
      cap = StrokeCap.Round
    ),
    topLeft = Offset(
      x = (size.width - componentSize.width)/2,
      y = (size.height - componentSize.height) /2f
    )
  )
}


@Composable
fun EmbeddedElements(
  bigText: String,
  bigTextFontSize: TextUnit,
  bigTextColor: Color,
  bigTextSuffix: String,
  smallText: String,
  smallTextFontSize: TextUnit,
  smallTextColor: Color
                     ) {
  Text(
    text = smallText,
    color = smallTextColor,
    fontSize = smallTextFontSize,
    textAlign = TextAlign.Center
  )

  Text(
    text = "$bigText ${bigTextSuffix.take(2)}",
    color = bigTextColor,
    fontSize = bigTextFontSize,
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Bold
  )
}

@Composable
@Preview(showBackground = true)
fun CharacterCountComposablePreview() {
  SampleComposeAppTheme {

    Column(modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally) {
      var value by remember { mutableStateOf(0) }
      CustomComponent(indicatorValue = value)
      TextField(
        value = value.toString(),
        onValueChange = {
          value = if(it.isNotEmpty()){
            it.toInt()
          }else{
            0
          }
        },
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Number
        )
      )

    }

  }
}