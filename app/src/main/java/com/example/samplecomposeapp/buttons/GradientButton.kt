package com.example.samplecomposeapp.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Button(colors = ButtonDefaults.buttonColors(
        contentColor = Color.White
    ),
        contentPadding = PaddingValues(),
        onClick = { onClick() }) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }

}


@Composable
@Preview
fun GradientButtonPreview() {
    GradientButton(
        "Click Me",
        Color.Blue, gradient = Brush.horizontalGradient(
            colors = listOf(
                Color(0x00000000),
                Color(0x00000000)
            )
        )
    )
}