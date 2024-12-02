package com.example.samplecomposeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.transformations
import coil3.transform.RoundedCornersTransformation


@Composable
fun CoilImageLoading(){
    Box(modifier = Modifier
        .height(150.dp)
        .width(150.dp),
        contentAlignment = Alignment.Center){
        AsyncImage(model = ImageRequest.Builder(context = LocalContext.current)
            .data("https://avatars.githubusercontent.com/u/14994036?v=4")
            .crossfade(true)
            .transformations(
                RoundedCornersTransformation(50f)
            )
            .build(),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape))
    }
}

@Composable
@Preview
fun CoilImageLoadingPreview(){
    CoilImageLoading()
}