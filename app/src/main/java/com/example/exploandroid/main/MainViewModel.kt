package com.example.exploandroid.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.OnTabSelected -> {
                val tabIndex = event.tabIndex.coerceIn(0, MainTab.entries.size - 1)
                _uiState.update { it.copy(selectedTabIndex = tabIndex) }
            }
        }
    }
}
