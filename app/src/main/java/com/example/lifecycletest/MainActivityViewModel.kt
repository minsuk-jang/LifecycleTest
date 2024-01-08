package com.example.lifecycletest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val _state: Flow<Int> = flow {
        var index = 0
        while (true) {
            delay(1000L)
            emit(index++)
        }
    }
    val state: Flow<Int> = _state

    private val _state1: Flow<Int> = flow {
        var index = 0
        while (true) {
            delay(1000L)
            emit(index++)
        }
    }
    val state1: Flow<Int> = _state1
}