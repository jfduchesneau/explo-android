package com.example.exploandroid.main

sealed interface MainEvent {
    data class OnTabSelected(val tabIndex: Int) : MainEvent
}
