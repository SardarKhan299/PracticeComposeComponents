package com.example.samplecomposeapp.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SideEffectAssignment() {

  val viewModel = viewModel<SideEffectViewModel>()

  Scaffold (
    snackbarHost = { SnackbarHost(viewModel.snackbarHostState) }
  ) { paddingValues ->
    LazyColumn(
      state = viewModel.listState,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      items(viewModel.items.size) { index ->
        ListItem(text = viewModel.items[index])
      }
    }
  }
}

@Composable
fun ListItem(text: String) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
    shape = MaterialTheme.shapes.medium
  ) {
    Text(
      text = text,
      modifier = Modifier.padding(16.dp)
    )
  }
}