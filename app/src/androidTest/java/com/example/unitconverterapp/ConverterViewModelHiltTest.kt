package com.example.unitconverterapp.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import javax.inject.Inject
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ConverterViewModelHiltTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var viewModel: ConverterViewModel

    @Test
    fun testConversionLogic() {
        hiltRule.inject()

        val result = viewModel.convert("Celsius", "Fahrenheit", "100")
        assertEquals("212.0", result)
    }
}
