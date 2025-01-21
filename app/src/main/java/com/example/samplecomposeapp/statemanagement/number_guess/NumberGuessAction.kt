package com.example.samplecomposeapp.statemanagement.number_guess

sealed interface NumberGuessAction {
  data object OnGuessClick: NumberGuessAction
  data class OnNumberTextChange(val newNumberText: String): NumberGuessAction
  data object OnStartNewGameButton: NumberGuessAction
}