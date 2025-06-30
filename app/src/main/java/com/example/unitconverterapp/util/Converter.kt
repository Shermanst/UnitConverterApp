package com.example.unitconverterapp.util

object Converter {
    fun convert(input: String, fromUnit: String, toUnit: String, category: ConversionCategory): String {
        val value = input.toDoubleOrNull() ?: return "Invalid input"
        return when (category) {
            ConversionCategory.TEMPERATURE -> {
                when {
                    fromUnit == "Celsius" && toUnit == "Fahrenheit" -> "${(value * 9 / 5) + 32}"
                    fromUnit == "Fahrenheit" && toUnit == "Celsius" -> "${(value - 32) * 5 / 9}"
                    else -> "Unsupported temperature conversion"
                }
            }
            ConversionCategory.WEIGHT -> {
                when {
                    fromUnit == "Kilograms" && toUnit == "Pounds" -> "${value * 2.20462}"
                    fromUnit == "Pounds" && toUnit == "Kilograms" -> "${value / 2.20462}"
                    else -> "Unsupported weight conversion"
                }
            }
            ConversionCategory.LENGTH -> {
                when {
                    fromUnit == "Meters" && toUnit == "Feet" -> "${value * 3.28084}"
                    fromUnit == "Feet" && toUnit == "Meters" -> "${value / 3.28084}"
                    else -> "Unsupported length conversion"
                }
            }
        }
    }
}
