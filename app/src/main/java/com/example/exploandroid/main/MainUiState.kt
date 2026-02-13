package com.example.exploandroid.main

data class MainUiState(
    val selectedTabIndex: Int = 0,
)

enum class MainTab(val title: String) {
    POC("POC"),
    TESTS("Tests"),
}
