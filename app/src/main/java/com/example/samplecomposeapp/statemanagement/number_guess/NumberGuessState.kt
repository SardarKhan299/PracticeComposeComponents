package com.example.samplecomposeapp.statemanagement.number_guess

data class NumberGuessState(
  val numberText: String = "1234",
  val guessText: String? = "",
  val isGuessCorrect: Boolean = false
)
