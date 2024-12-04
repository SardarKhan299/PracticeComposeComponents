package com.example.samplecomposeapp.textview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.samplecomposeapp.AndroidConnectivityObserver
import com.example.samplecomposeapp.ConnectivityViewModel
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import com.example.samplecomposeapp.ui.theme.Typography

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleComposeAppTheme {
                val viewmodel = viewModel<ConnectivityViewModel> {
                    ConnectivityViewModel(
                        connectivityObserver = AndroidConnectivityObserver(applicationContext)
                    )
                }
                val isConnected by viewmodel.isConnected.collectAsStateWithLifecycle()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Connected: $isConnected")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var myState = remember { mutableStateOf(false) }
    Log.e(MainActivity::class.simpleName, "Greeting: ${myState.value}")
    Button(onClick = {
        myState.value = !myState.value
    }) {
        Text(
            text = "Hello $name! state is ${myState.value}",
            modifier = modifier
        )
        Log.e(MainActivity::class.simpleName, "Greeting: Text ${myState.value}")
    }

}

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        style = Typography.headlineMedium
    )
}

@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color) {
    Surface(
        modifier = Modifier
            .padding(12.dp)
            .width(300.dp)
            .height(50.dp)
            .weight(weight),
        color = color
    ) {
        CustomText("Sardar")
    }
}

@Preview(
    showBackground = true,
    name = "First Preview"
)
@Composable
fun GreetingPreview() {
    SampleComposeAppTheme {

//        Column(modifier = Modifier.fillMaxSize().height(500.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center) {
//            CustomItem(2f, Color.Blue)
//            CustomItem(1f, Color.Red)
//            CustomItem(1f, Color.Green)
//
//
//        }

        BoxPractice()

    }
}