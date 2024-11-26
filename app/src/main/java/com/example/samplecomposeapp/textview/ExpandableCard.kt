package com.example.samplecomposeapp.textview

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun ExpandableCard(title:String,
                   titleFontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
                   titleFontWeight: FontWeight = FontWeight.Bold,
                   descriptionText:String,
                   descriptionFontSize: TextUnit = MaterialTheme.typography.bodySmall.fontSize,
                   descriptionFontWeight: FontWeight = FontWeight.Normal,
                   descriptionMaxLines:Int = 4,
                   cardShape: CornerBasedShape = Shapes().medium,
                   padding: Dp = 12.dp,
                   durations: Int = 300,

                   ){
    var expanded by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if(expanded) 180f else 0f
    )

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            tween(durationMillis = if(expanded) durations else durations*4 ,
                easing = LinearOutSlowInEasing)
        ),
        shape = cardShape,
        onClick = {
            expanded = !expanded
        }

    ) {

        Column(modifier = Modifier.fillMaxWidth()
            .padding(padding)) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text = title,
                    modifier = Modifier.weight(6f),
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                    )

                IconButton(modifier = Modifier
                    .weight(1f,true)
                    .alpha(1.toFloat())
                    .rotate(rotationState)
                    ,
                    onClick = {
                        expanded = !expanded
                    }
                    ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Image Drop Down")
                }

            }

            if(expanded){
                Text(text = descriptionText,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
            }
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview(){
    SampleComposeAppTheme {
        ExpandableCard(title = "My Title", descriptionText = " Some long text with some long description " +
                "                        Some text here as well to handle the description  "+
                "                        lets test and run the app..")
    }
}