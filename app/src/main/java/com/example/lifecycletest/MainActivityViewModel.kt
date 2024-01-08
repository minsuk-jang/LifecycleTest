package com.example.lifecycletest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val _state: MutableStateFlow<Int> = MutableStateFlow(0)
    val state: StateFlow<Int> = _state.asStateFlow()

    fun run() {
        viewModelScope.launch {
            var index = 0
            while (true) {
                delay(1000L)
                _state.update { index++ }
            }
        }
    }
}