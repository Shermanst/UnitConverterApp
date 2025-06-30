package com.example.unitconverterapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
//import androidx.compose.ui.test.junit4.hasTextStartingWith
//import androidx.compose.ui.test.hasTextStartingWith
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.assertTextContains


class MainActivityUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testConversionUIElementsDisplayed() {
        composeTestRule.onNodeWithTag("inputField").assertIsDisplayed()
        composeTestRule.onNodeWithTag("convertButton").assertIsDisplayed()
        composeTestRule.onNodeWithTag("resultText").assertIsDisplayed()
    }

    @Test
    fun testConvertTemperature() {
        composeTestRule.onNodeWithTag("inputField")
            .performTextInput("100")

        composeTestRule.onNodeWithTag("convertButton")
            .performClick()

        // Wait for recomposition and UI update
        composeTestRule.waitUntil(2_000) {
            composeTestRule.onAllNodesWithTag("resultText").fetchSemanticsNodes().isNotEmpty()
        }

        composeTestRule.onNodeWithTag("resultText").assertTextContains("Result: 212.0")
        //composeTestRule
        //.onNode(hasTextStartingWith("Result:"), useUnmergedTree = true)
        //.assertExists()
    }
}



