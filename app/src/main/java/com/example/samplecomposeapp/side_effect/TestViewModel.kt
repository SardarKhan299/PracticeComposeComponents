package com.example.samplecomposeapp.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class TestViewModel: ViewModel() {
  private val _state = MutableStateFlow(0)
  val state = _state.asStateFlow()

  // all of the compose state inside the snapshotFlow it will trigger new emission when state actually change.//
  private val myStateAsFlow = snapshotFlow {
    state
  }.stateIn(
    viewModelScope,
    SharingStarted.WhileSubscribed(5000),
    0
  )

  @Composable
  fun MYComposable(modifier: Modifier = Modifier){
    val viewModel = viewModel<TestViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
  }

}