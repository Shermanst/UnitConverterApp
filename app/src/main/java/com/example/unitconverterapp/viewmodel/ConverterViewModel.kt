package com.example.unitconverterapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unitconverterapp.util.ConversionCategory
import com.example.unitconverterapp.util.Converter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ConverterViewModel @Inject constructor(
    private val converter: Converter
) : ViewModel() {


    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    fun performConversion(input: String, fromUnit: String, toUnit: String, category: ConversionCategory) {
        val converted = converter.convert(input, fromUnit, toUnit, category)
        _result.value = converted
    }

   fun convert(fromUnit: String, toUnit: String, input: String): String {
        val category = when {
            fromUnit.contains("C", true) || toUnit.contains("F", true) -> ConversionCategory.TEMPERATURE
            fromUnit.contains("m", true) || toUnit.contains("ft", true) -> ConversionCategory.LENGTH
            else -> ConversionCategory.WEIGHT
        }
        return converter.convert(input, fromUnit, toUnit, category)
    }
}

