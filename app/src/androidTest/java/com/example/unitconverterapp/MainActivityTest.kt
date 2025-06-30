package com.example.unitconverterapp

import com.example.unitconverterapp.ConverterScreen
import com.example.unitconverterapp.viewmodel.ConverterViewModel
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import com.example.unitconverterapp.ConverterScreen
import com.example.unitconverterapp.util.Converter


class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appLaunchesSuccessfully() {
        composeTestRule.setContent {
            ConverterScreen(viewModel = ConverterViewModel(converter = Converter))

        }

        composeTestRule
            .onNodeWithText("Unit Converter")
            .assertIsDisplayed()
    }
}
