package com.example.samplecomposeapp.statemanagement.number_guess

data class NumberGuessState(
  val numberText: String = "",
  val guessText: String? = "",
  val isGuessCorrect: Boolean = false
)
