package com.example.samplecomposeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class ConnectivityViewModel(private val connectivityObserver: ConnectivityObserver) :ViewModel() {
    private val _isConnected = connectivityObserver.isConnected
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), false)
    val isConnected = _isConnected
}