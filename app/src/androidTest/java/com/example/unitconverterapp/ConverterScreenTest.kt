package com.example.unitconverterapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import org.junit.Rule
import org.junit.Test
import com.example.unitconverterapp.ConverterScreen
import com.example.unitconverterapp.viewmodel.ConverterViewModel
import com.example.unitconverterapp.util.Converter


class ConverterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun inputTemperature_showsConvertedValue() {
        composeTestRule.setContent {
            UnitConverterAppTheme {
                ConverterScreen(viewModel = ConverterViewModel(Converter))
            }
        }

        // Simulate user input: enter "100"
        composeTestRule
            .onNodeWithTag("inputField")
            .performTextInput("100")

        // Assert result is not empty (you can improve this once exact result is known)
        composeTestRule
            .onNodeWithTag("resultText")
            .assertIsDisplayed()
            .assertTextContains("212") // 100C = 212F
    }
}
