package com.example.samplecomposeapp.side_effect

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SideEffectViewModel: ViewModel() {
  val snackbarHostState = SnackbarHostState()
  val listState = LazyListState()
  val items = List(30) { "Item $it" }

  init {
    viewModelScope.launch {
      snapshotFlow { listState.layoutInfo.visibleItemsInfo }
        .collect { visibleItems ->
          val lastItemIndex = items.lastIndex
          if (visibleItems.isNotEmpty() && visibleItems.last().index == lastItemIndex) {
              snackbarHostState.showSnackbar("Scrolled to the bottom!")
          }
        }
    }
  }

}