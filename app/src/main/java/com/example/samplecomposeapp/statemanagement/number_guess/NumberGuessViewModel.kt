package com.example.samplecomposeapp.statemanagement.number_guess

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel: ViewModel() {

  // to save the state..//
//  var screenState by mutableStateOf(NumberGuessState())
//      private set

  // alternative approach to save state..Recommended approach...//
  private val _state = MutableStateFlow(NumberGuessState())
  val state = _state.asStateFlow()

  private var number = Random.nextInt(0,101)
  private var attempts = 0


  fun onAction(action: NumberGuessAction) {
   when(action){
     NumberGuessAction.OnGuessClick ->{
       val guess = _state.value.numberText.toIntOrNull()
       if(guess!=null) {
         attempts++
       }

       _state.update {
         it.copy(
           guessText = when{
             guess == null -> "Please Enter a number."
             number > guess -> "Nope, my number is larger."
             number < guess -> "Nope, my number is smaller."
             else -> "That was it! You needed $attempts attempts."
           },
           isGuessCorrect = guess == number,
           numberText = ""
         )
       }
     }
     is NumberGuessAction.OnNumberTextChange -> {
       _state.update { it.copy(
         numberText = action.newNumberText
       )
       }
     }

     NumberGuessAction.OnStartNewGameButton ->{
       _state.update {
         number = Random.nextInt(1,101)
         it.copy(
           numberText = "",
           guessText = null,
           isGuessCorrect = false
         )
       }
     }

   }
  }






}