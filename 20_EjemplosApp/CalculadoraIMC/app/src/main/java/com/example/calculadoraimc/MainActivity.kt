package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMCTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedSex by remember { mutableStateOf("Hombre") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var imc by remember { mutableStateOf<Double?>(null) }
    var imcStatus by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Calculadora de IMC") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Sexo
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedSex == "Hombre",
                    onClick = { selectedSex = "Hombre" }
                )
                Text(text = "Hombre")
                Spacer(modifier = Modifier.weight(1f))
                RadioButton(
                    selected = selectedSex == "Mujer",
                    onClick = { selectedSex = "Mujer" }
                )
                Text(text = "Mujer")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Edad
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Edad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Altura
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Altura (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Peso
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Peso (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón Calcular
            Button(onClick = {
                if (age.isNotEmpty() && height.isNotEmpty() && weight.isNotEmpty()) {
                    val heightInMeters = height.toDouble() / 100
                    val weightInKg = weight.toDouble()
                    val calculatedImc = weightInKg / (heightInMeters * heightInMeters)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.DOWN
                    imc = df.format(calculatedImc).toDouble()
                    imcStatus = getImcStatus(imc!!)
                }
            }) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Resultado
            if (imc != null) {
                Text(text = "Tu IMC es: $imc", style = MaterialTheme.typography.headlineSmall)
                Text(text = "Estado: $imcStatus", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

fun getImcStatus(imc: Double): String {
    return when {
        imc < 18.5 -> "Bajo peso"
        imc < 25 -> "Peso normal"
        imc < 30 -> "Sobrepeso"
        else -> "Obesidad"
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CalculadoraIMCTheme {
        MainScreen()
    }
}