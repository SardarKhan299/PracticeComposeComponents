package com.example.samplecomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.samplecomposeapp.modifiers.SpacingModifierPractice
import com.example.samplecomposeapp.statemanagement.number_guess.NumberGuessScreenRoot
import com.example.samplecomposeapp.statemanagement.todo_list_check.TodoListScreenRoot
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import com.example.samplecomposeapp.ui.theme.Typography
import com.example.samplecomposeapp.ui_practice.layouts.BoxPractice
import com.example.samplecomposeapp.ui_practice.list.repository.PersonRepository
import com.example.samplecomposeapp.ui_practice.navigation.navgraph.SetupNavGraph

class MainActivity : ComponentActivity() {

  lateinit var navController: NavHostController

  @OptIn(ExperimentalFoundationApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SampleComposeAppTheme {

        // To check Number Guess game..//
        //NumberGuessScreenRoot(Modifier.fillMaxSize())

        // To check TodoList..//
        TodoListScreenRoot(Modifier.fillMaxWidth())

        // To check Modifier..//
        //SpacingModifierPractice()

        // for navigation..//
//        navController = rememberNavController()
//        SetupNavGraph(
//          navController = navController
//        )

        // For Observe Internet Connectivity...//
//        val viewmodel = viewModel<ConnectivityViewModel> {
//          ConnectivityViewModel(
//            connectivityObserver = AndroidConnectivityObserver(applicationContext)
//          )
//        }
//        val isConnected by viewmodel.isConnected.collectAsStateWithLifecycle()

        val personRepository = PersonRepository()
        val getAllData = personRepository.getAllData()

//        LazyColumn(
//          contentPadding = PaddingValues(all = 32.dp),
//          verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
////                    itemsIndexed(items = getAllData){
////                        index, person->
////                        // for checking the index of visible item..//
////                        CustomItem(person = person)
////                    }
////                    items(items = getAllData){ person->
////                        CustomItem(person = person)
////                    }
//
//          // items with keys..//
////                    itemsIndexed(items = getAllData,
////                        key = {
////                            index, person->
////                            // that is the unique key for parameter...//
////                            person.id
////                        }){
////                            index, person->
////                        // for checking the index of visible item..//
////                        CustomItem(person = person)
////                    }
//
//          // sticky header example with lazy Column....//
//          val sections = listOf("A", "B", "C", "D", "E", "F", "G")
//
//          sections.forEach { section ->
//            stickyHeader {
//              Text(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.LightGray)
//                    .padding(12.dp),
//                text = "Section $section"
//              )
//            }
//            items(10) {
//              Text(
//                modifier = Modifier.padding(12.dp),
//                text = "Item $it from the section $section"
//              )
//            }
//          }
//
//        }


        // for checking the state of network connection..//
//                 old(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "Connected: $isConnected")
//                    }
//                }
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
fun Test(modifier: Modifier = Modifier) {
  val fontSize = 20
  val baseHeight = 30

  val adjustedHeight = when (fontSize) {
    in 10..20 -> baseHeight * 1.2
    in 21..30 -> baseHeight * 1.5
    in 31..40 -> baseHeight * 2
    in 41..50 -> baseHeight * 4
    in 51..60 -> baseHeight * 4.5
    in 61..70 -> baseHeight * 5.5
    else -> baseHeight * 5.5
  }
  Button(
    modifier = modifier
      .height(adjustedHeight.toInt().dp),
    onClick = {  },
    shape = RectangleShape,
    contentPadding = PaddingValues(vertical = 0.dp)
  ) {
    Text(text = "Some Text", fontSize = fontSize.sp)
  }

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
    Test()

    //BoxPractice()

  }
}