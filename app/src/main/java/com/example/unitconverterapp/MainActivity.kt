package com.example.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import com.example.unitconverterapp.viewmodel.ConverterViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.unitconverterapp.util.ConversionCategory

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    private val viewModel: ConverterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ConverterScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun ConverterScreen(viewModel: ConverterViewModel) {
    val conversionTypes = listOf("Temperature", "Length", "Weight")
    var selectedType by remember { mutableStateOf(conversionTypes[0]) }

    val units = when (selectedType) {
        "Temperature" -> listOf("Celsius", "Fahrenheit", "Kelvin")
        "Length" -> listOf("Meters", "Feet", "Inches")
        "Weight" -> listOf("Kilograms", "Pounds", "Grams")
        else -> emptyList()
    }

    var input by remember { mutableStateOf("") }
    var fromUnit by remember { mutableStateOf(units.first()) }
    var toUnit by remember { mutableStateOf(units[1]) }
    val result by viewModel.result.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", style = MaterialTheme.typography.headlineMedium)

        Text("Select Conversion Type")

        DropdownMenuBox(conversionTypes, selectedType) {
            selectedType = conversionTypes[it]
        }

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Enter value") },
            modifier = Modifier.testTag("inputField")
        )

        Spacer(Modifier.height(16.dp))

        Text("From")
        DropdownMenuBox(units, fromUnit) {
            fromUnit = units[it]
        }

        Text("To")
        DropdownMenuBox(units, toUnit) {
            toUnit = units[it]
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val category = when (selectedType.uppercase()) {
                    "TEMPERATURE" -> ConversionCategory.TEMPERATURE
                    "LENGTH" -> ConversionCategory.LENGTH
                    "WEIGHT" -> ConversionCategory.WEIGHT
                    else -> ConversionCategory.TEMPERATURE
                }

                viewModel.performConversion(input, fromUnit, toUnit, category)
            }
        ) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $result")
    }
}

@Composable
fun DropdownMenuBox(options: List<String>, selected: String, onSelect: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(selected)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEachIndexed { index, option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelect(index)
                        expanded = false
                    }
                )
            }
        }
    }
}
