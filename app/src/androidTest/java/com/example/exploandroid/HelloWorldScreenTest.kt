package com.example.exploandroid

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HelloWorldScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun actionButton_click_displaysHelloWorld() {
        composeTestRule.onNodeWithText("Action").performClick()
        composeTestRule.onNodeWithText("Hello World").assertIsDisplayed()
    }

    @Test
    fun redButton_click_displaysRed() {
        composeTestRule.onNodeWithText("Red").performClick()
        composeTestRule.onNodeWithText("Red!").assertIsDisplayed()
    }

    @Test
    fun greenButton_click_displaysGreen() {
        composeTestRule.onNodeWithText("Green").performClick()
        composeTestRule.onNodeWithText("Green!").assertIsDisplayed()
    }
}
