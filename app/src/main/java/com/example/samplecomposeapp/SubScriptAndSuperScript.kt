package com.example.samplecomposeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme


@Composable
fun SuperScriptText(normalText:String,
                    superText:String){
    // Build Annotated String is used to Style Each Character of a string..//
Text(buildAnnotatedString {
    withStyle(style =
    SpanStyle(fontSize = MaterialTheme.typography.bodyLarge.fontSize,)
    ){
        append(normalText)
    }

    withStyle(style = SpanStyle(fontSize = MaterialTheme.typography.bodySmall.fontSize,
        fontWeight = FontWeight.Normal,
        // to shift it to subscript change this baseline shift to subscript.
        baselineShift = androidx.compose.ui.text.style.BaselineShift.Superscript
        )){
        append(superText)
    }
})
}


@Preview(showBackground = true)
@Composable
fun PreviewComposeable(){
    SampleComposeAppTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            SuperScriptText("Sardar","Khan")
        }
    }
}
