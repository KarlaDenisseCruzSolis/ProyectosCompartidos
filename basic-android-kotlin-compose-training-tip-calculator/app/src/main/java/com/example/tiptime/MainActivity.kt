/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat


/**
 * La actividad principal de la aplicación TipTime.
 * Hereda de ComponentActivity, que es la clase base para actividades que usan Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    /**
     * Llamado cuando la actividad se crea por primera vez.
     * Aquí es donde se configuran los elementos de la interfaz de usuario.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita el modo de pantalla completa para que el contenido se extienda hasta los bordes.
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        // Establece el contenido de la interfaz de usuario de la actividad utilizando Jetpack Compose.
        setContent {
            // Aplica el tema definido para la aplicación TipTime.
            TipTimeTheme {
                // Una superficie que ocupa todo el tamaño disponible, sirviendo como contenedor principal.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    // La función componible principal que define el diseño de la aplicación.
                    TipTimeLayout()
                }
            }
        }
    }
}

/**
 * Composable que define el diseño principal de la aplicación para calcular propinas.
 */
@Composable
fun TipTimeLayout() {
    // Estado mutable para el monto de la cuenta, inicializado como una cadena vacía.
    var amountInput by remember { mutableStateOf("") }
    // Estado mutable para el porcentaje de propina, inicializado como una cadena vacía.
    var tipInput by remember { mutableStateOf("") }
    // Estado mutable para la opción de redondear la propina, inicializado en falso.
    var roundUp by remember { mutableStateOf(false) }

    // Convierte el monto de entrada a Double, o 0.0 si la entrada no es un número válido.
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    // Convierte el porcentaje de propina de entrada a Double, o 0.0 si la entrada no es un número válido.
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    // Calcula el monto de la propina usando la función calculateTip.
    val tip = calculateTip(amount, tipPercent, roundUp)

    // Columna principal que organiza los elementos de la interfaz de usuario verticalmente.
    Column(
        modifier = Modifier
            .statusBarsPadding() // Añade padding para evitar la barra de estado.
            .padding(horizontal = 40.dp) // Padding horizontal.
            .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical si el contenido excede la pantalla.
            .safeDrawingPadding(), // Añade padding para evitar áreas de dibujo inseguras (como muescas).
        horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos horizontalmente.
        verticalArrangement = Arrangement.Center // Centra los elementos verticalmente.
    ) {
        // Texto del título de la aplicación.
        Text(
            text = stringResource(R.string.calculate_tip), // Obtiene el texto del recurso de cadena.
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp) // Padding inferior y superior.
                .align(alignment = Alignment.Start) // Alinea el texto al inicio (izquierda).
        )
        // Campo de texto para ingresar el monto de la cuenta.
        EditNumberField(
            label = R.string.bill_amount, // Etiqueta del campo.
            leadingIcon = R.drawable.money, // Icono principal del campo.
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number, // Tipo de teclado numérico.
                imeAction = ImeAction.Next // Acción del teclado para pasar al siguiente campo.
            ),
            value = amountInput, // Valor actual del campo.
            onValueChanged = { amountInput = it }, // Callback cuando el valor cambia.
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(), // Padding inferior y ancho completo.
        )
        // Campo de texto para ingresar el porcentaje de propina.
        EditNumberField(
            label = R.string.how_was_the_service, // Etiqueta del campo.
            leadingIcon = R.drawable.percent, // Icono principal del campo.
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number, // Tipo de teclado numérico.
                imeAction = ImeAction.Done // Acción del teclado para finalizar.
            ),
            value = tipInput, // Valor actual del campo.
            onValueChanged = { tipInput = it }, // Callback cuando el valor cambia.
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(), // Padding inferior y ancho completo.
        )
        // Fila para la opción de redondear la propina.
        RoundTheTipRow(
            roundUp = roundUp, // Estado actual del interruptor.
            onRoundUpChanged = { roundUp = it }, // Callback cuando el estado del interruptor cambia.
            modifier = Modifier.padding(bottom = 32.dp) // Padding inferior.
        )
        // Texto que muestra el monto de la propina calculada.
        Text(
            text = stringResource(R.string.tip_amount, tip), // Obtiene el texto del recurso de cadena y formatea la propina.
            style = MaterialTheme.typography.displaySmall // Aplica un estilo de tipografía.
        )
        Spacer(modifier = Modifier.height(150.dp)) // Espaciador al final de la columna.
    }
}

/**
 * Composable para un campo de entrada de texto numérico.
 *
 * @param label El ID del recurso de cadena para la etiqueta del campo de texto.
 * @param leadingIcon El ID del recurso drawable para el ícono principal.
 * @param keyboardOptions Las opciones del teclado para el campo de texto.
 * @param value El valor actual del campo de texto.
 * @param onValueChanged El callback que se invoca cuando el valor del campo de texto cambia.
 * @param modifier Un modificador para aplicar a este componible.
 */
@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Campo de texto de Material Design.
    TextField(
        value = value, // El valor actual del campo de texto.
        singleLine = true, // Permite que el texto se muestre en una sola línea.
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) }, // Icono al inicio del campo.
        modifier = modifier, // Modificador aplicado al campo de texto.
        onValueChange = onValueChanged, // Callback para manejar cambios en el texto.
        label = { Text(stringResource(label)) }, // Etiqueta del campo de texto.
        keyboardOptions = keyboardOptions // Opciones del teclado.
    )
}

/**
 * Composable que muestra una fila con un texto y un interruptor para redondear la propina.
 *
 * @param roundUp El estado actual del interruptor (redondear o no).
 * @param onRoundUpChanged El callback que se invoca cuando el estado del interruptor cambia.
 * @param modifier Un modificador para aplicar a este componible.
 */
@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // Fila que contiene el texto y el interruptor.
    Row(
        modifier = modifier.fillMaxWidth(), // La fila ocupa todo el ancho disponible.
        verticalAlignment = Alignment.CenterVertically // Alinea los elementos verticalmente al centro.
    ) {
        Text(text = stringResource(R.string.round_up_tip)) // Texto para la opción de redondear.
        Switch(
            modifier = Modifier
                .fillMaxWidth() // El interruptor intenta ocupar todo el ancho restante.
                .wrapContentWidth(Alignment.End), // Se alinea a la derecha dentro de su espacio.
            checked = roundUp, // Estado actual del interruptor.
            onCheckedChange = onRoundUpChanged // Callback para cuando el interruptor cambia de estado.
        )
    }
}

/**
 * Calcula la propina basándose en la entrada del usuario y formatea el monto de la propina
 * según la moneda local.
 * Por ejemplo, el resultado sería "$10.00".
 *
 * @param amount El monto total de la cuenta.
 * @param tipPercent El porcentaje de propina a aplicar (por defecto 15.0).
 * @param roundUp Un booleano que indica si la propina debe redondearse al número entero más cercano.
 * @return La propina calculada como una cadena formateada.
 */
private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount // Calcula el monto de la propina.
    if (roundUp) {
        tip = kotlin.math.ceil(tip) // Redondea la propina al siguiente entero si roundUp es verdadero.
    }
    return NumberFormat.getCurrencyInstance().format(tip) // Formatea la propina como moneda.
}

/**
 * Vista previa del diseño de la aplicación TipTime.
 */
@Preview(showBackground = true) // Muestra un fondo en la vista previa.
@Composable
fun TipTimeLayoutPreview() {
    // Aplica el tema de la aplicación a la vista previa.
    TipTimeTheme {
        TipTimeLayout() // Muestra el diseño principal de la aplicación.
    }
}