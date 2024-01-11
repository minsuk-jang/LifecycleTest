package com.example.lifecycletest

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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