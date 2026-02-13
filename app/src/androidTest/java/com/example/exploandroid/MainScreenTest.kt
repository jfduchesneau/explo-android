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
class MainScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun tabs_areDisplayed() {
        composeTestRule.onNodeWithText("POC").assertIsDisplayed()
        composeTestRule.onNodeWithText("Tests").assertIsDisplayed()
    }

    @Test
    fun pocTab_isSelectedByDefault() {
        composeTestRule.onNodeWithText("Proof of Concepts").assertIsDisplayed()
    }

    @Test
    fun testsTab_click_showsTestsContent() {
        composeTestRule.onNodeWithText("Tests").performClick()
        composeTestRule.onNodeWithText("Engineering Tests").assertIsDisplayed()
    }

    @Test
    fun switchingTabs_updatesContent() {
        // Verify POC tab content is shown initially
        composeTestRule.onNodeWithText("Proof of Concepts").assertIsDisplayed()

        // Switch to Tests tab
        composeTestRule.onNodeWithText("Tests").performClick()
        composeTestRule.onNodeWithText("Engineering Tests").assertIsDisplayed()

        // Switch back to POC tab
        composeTestRule.onNodeWithText("POC").performClick()
        composeTestRule.onNodeWithText("Proof of Concepts").assertIsDisplayed()
    }
}
