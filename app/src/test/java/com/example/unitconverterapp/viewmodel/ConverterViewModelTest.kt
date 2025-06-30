package com.example.unitconverterapp.viewmodel

import com.example.unitconverterapp.util.ConversionCategory
import com.example.unitconverterapp.util.Converter
import io.mockk.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class ConverterViewModelTest {

    private lateinit var viewModel: ConverterViewModel
    private lateinit var mockConverter: Converter

    @Before
    fun setup() {
        // Use mock for one test, real for another
        mockConverter = mockk()
        viewModel = ConverterViewModel(mockConverter)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `test performConversion with mocked converter`() {
        val input = "100"
        val fromUnit = "Celsius"
        val toUnit = "Fahrenheit"
        val expected = "212.0"

        every {
            mockConverter.convert(input, fromUnit, toUnit, ConversionCategory.TEMPERATURE)
        } returns expected

        viewModel.performConversion(input, fromUnit, toUnit, ConversionCategory.TEMPERATURE)

        assertEquals(expected, viewModel.result.value)

        verify {
            mockConverter.convert(input, fromUnit, toUnit, ConversionCategory.TEMPERATURE)
        }
    }

    @Test
    fun `test performConversion with real converter`() {
        val realViewModel = ConverterViewModel(Converter) // Not mocked
        realViewModel.performConversion("100", "Celsius", "Fahrenheit", ConversionCategory.TEMPERATURE)
        assertEquals("212.0", realViewModel.result.value)
    }
}
