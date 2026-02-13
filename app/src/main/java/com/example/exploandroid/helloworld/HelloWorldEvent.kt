package com.example.exploandroid.helloworld

sealed interface HelloWorldEvent {
    data object OnActionButtonClick : HelloWorldEvent
}
