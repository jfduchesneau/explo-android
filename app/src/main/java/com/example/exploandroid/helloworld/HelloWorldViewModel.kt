package com.example.exploandroid.helloworld

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HelloWorldViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HelloWorldUiState())
    val uiState: StateFlow<HelloWorldUiState> = _uiState.asStateFlow()

    fun onEvent(event: HelloWorldEvent) {
        when (event) {
            is HelloWorldEvent.OnActionButtonClick -> viewModelScope.launch {
                _uiState.update { it.copy(message = "Hello World") }
            }
        }
    }
}
