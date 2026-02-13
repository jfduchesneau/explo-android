package com.example.exploandroid.helloworld

sealed interface HelloWorldEvent {
    // TODO: Add a new event for the Green button
    data object OnActionButtonClick : HelloWorldEvent
    data object OnRedButtonClick : HelloWorldEvent
    data object OnGreenButtonClick : HelloWorldEvent
}
