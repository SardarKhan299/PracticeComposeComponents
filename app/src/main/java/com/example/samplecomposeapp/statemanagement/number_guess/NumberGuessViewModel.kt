package com.example.samplecomposeapp.statemanagement.number_guess

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NumberGuessViewModel(
  private val test: String
): ViewModel() {

  // to save the state..//
//  var screenState by mutableStateOf(NumberGuessState())
//      private set

  // alternative approach to save state..Recommended approach...//
  private val _state = MutableStateFlow(NumberGuessState())
  val state = _state.asStateFlow()


  fun onAction(action: NumberGuessAction) {
   when(action){

     NumberGuessAction.OnGuessClick ->{

     }
     is NumberGuessAction.OnNumberTextChange ->{

     }

     NumberGuessAction.OnStartNewGameButton ->{

     }

   }
  }






}