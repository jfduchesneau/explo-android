package com.example.exploandroid.helloworld

sealed interface HelloWorldEvent {
    data object OnActionButtonClick : HelloWorldEvent
    data object OnRedButtonClick : HelloWorldEvent
    data object OnGreenButtonClick : HelloWorldEvent
}
