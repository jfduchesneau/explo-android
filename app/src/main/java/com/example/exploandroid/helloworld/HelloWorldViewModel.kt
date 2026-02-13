package com.example.exploandroid.helloworld

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HelloWorldViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HelloWorldUiState())
    val uiState: StateFlow<HelloWorldUiState> = _uiState.asStateFlow()

    fun onEvent(event: HelloWorldEvent) {
        when (event) {
            is HelloWorldEvent.OnActionButtonClick -> {
                _uiState.update { it.copy(message = "Hello World") }
            }
        }
    }
}
