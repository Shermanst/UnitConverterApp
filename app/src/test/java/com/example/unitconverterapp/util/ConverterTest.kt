package com.example.unitconverterapp.util

import com.example.unitconverterapp.util.ConversionCategory
import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterTest {

    @Test
    fun testCelsiusToFahrenheit() {
        val result = Converter.convert("0", "Celsius", "Fahrenheit", ConversionCategory.TEMPERATURE)
        assertEquals("32.0", result)
    }

    @Test
    fun testFahrenheitToCelsius() {
        val result = Converter.convert("32", "Fahrenheit", "Celsius", ConversionCategory.TEMPERATURE)
        assertEquals("0.0", result)
    }

    @Test
    fun testMetersToFeet() {
        val result = Converter.convert("1", "Meters", "Feet", ConversionCategory.LENGTH)
        assertEquals("3.28084", result)
    }

    @Test
    fun testFeetToMeters() {
        val result = Converter.convert("3.28084", "Feet", "Meters", ConversionCategory.LENGTH)
        assertEquals("1.0", result)
    }
}
