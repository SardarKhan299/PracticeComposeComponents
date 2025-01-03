package com.example.samplecomposeapp.textview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.R
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun CustomizeText() {
    Text(
        text = stringResource(R.string.app_name), modifier = Modifier
            .background(Color.Blue)
            .padding(16.dp),
        color = Color.White,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CustomizeText2() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("S")
            }
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("A")
            }
            append("S")
            append("A")
            append("R")
        }
    )
}

@Composable
fun CustomizeText3() {
    SelectionContainer {
        Column {
            Text(text = "Hello from Android")
            DisableSelection {
                Text(text = "Hello from Android 1")
            }
            Text(text = "Hello from Android 2")
        }
    }
}

@Composable
fun GreetingText(name: String){
    Text(
        text = "Hello. $name!",
        color = Color.Blue,
        fontSize = 30.sp,
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
            .background(Color.Green)
            .padding(8.dp)
            .background(Color.Black)
    )
}

@Composable
fun TextOnEachOther(name: String){
    Text(
        text = "Hello. $name!",
        color = Color.Blue,
        fontSize = 30.sp,
    )
    Text(
        text = "Some Other text",
        color = Color.Blue,
        fontSize = 30.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleComposeAppTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomizeText()
            CustomizeText2()
            CustomizeText3()
            GreetingText("Sardar Khan")
            TextOnEachOther("Sardar Khan")
        }
    }
}