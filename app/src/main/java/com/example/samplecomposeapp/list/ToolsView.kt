package com.example.samplecomposeapp.list

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

@Composable
fun ToolsView(modifier: Modifier = Modifier,
              state: ToolsViewState){
    Scaffold(modifier= modifier ,
        contentColor = MaterialTheme.colorScheme.primary) {
            paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)){

        }
    }


}


@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreViewTools(){
    SampleComposeAppTheme {
        ToolsView(state = ToolsViewState())
    }
}