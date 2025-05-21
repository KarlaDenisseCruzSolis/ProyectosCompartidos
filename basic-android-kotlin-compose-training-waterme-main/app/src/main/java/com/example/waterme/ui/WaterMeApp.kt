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

package com.example.waterme.ui // Define el paquete al que pertenece este archivo

// Importación de componentes de Jetpack Compose y Android necesarios para la UI
import androidx.compose.foundation.clickable // Permite que un elemento sea clickeable
import androidx.compose.foundation.layout.* // Importa múltiples elementos de layout
import androidx.compose.foundation.lazy.LazyColumn // Lista vertical perezosa (sólo renderiza lo visible)
import androidx.compose.foundation.lazy.items // Para iterar sobre listas en LazyColumn
import androidx.compose.material3.AlertDialog // Muestra un diálogo con opciones
import androidx.compose.material3.Card // Contenedor con borde y fondo elevado
import androidx.compose.material3.MaterialTheme.typography // Accede a estilos de texto
import androidx.compose.runtime.* // Importa funciones y tipos para estado y composición
import com.example.waterme.data.Reminder // Importa la clase Reminder
import com.example.waterme.model.Plant // Importa el modelo de planta
import androidx.compose.ui.Modifier // Modificador para modificar apariencia y comportamiento
import androidx.compose.material3.Surface // Superficie base para pintar contenido
import androidx.compose.material3.Text // Componente para mostrar texto
import androidx.compose.ui.platform.LocalLayoutDirection // Accede a la dirección de layout (LTR o RTL)
import androidx.compose.ui.res.dimensionResource // Permite obtener dimensiones desde recursos XML
import androidx.compose.ui.res.stringResource // Permite obtener strings desde recursos
import androidx.compose.ui.text.style.TextAlign // Permite alinear texto
import androidx.compose.ui.unit.dp // Define unidades de medida en dp
import androidx.lifecycle.viewmodel.compose.viewModel // Para obtener el ViewModel dentro de Compose
import com.example.waterme.ui.theme.WaterMeTheme // Importa el tema personalizado WaterMe
import com.example.waterme.* // Importa constantes como FIVE_SECONDS, ONE_DAY, etc.
import com.example.waterme.R // Referencia a recursos como strings y dimens
import com.example.waterme.data.DataSource // Fuente de datos de plantas
import androidx.compose.ui.tooling.preview.Preview // Permite previsualizar componentes en Compose
import java.util.concurrent.TimeUnit // Unidad de tiempo (segundos, días, etc.)
import androidx.compose.runtime.saveable.rememberSaveable


@Composable
fun WaterMeApp(waterViewModel: WaterViewModel = viewModel(factory = WaterViewModel.Factory)) {
    val layoutDirection = LocalLayoutDirection.current // Obtiene si el diseño es de izquierda a derecha o viceversa
    WaterMeTheme { // Aplica el tema WaterMe a todo el contenido
        Surface( // Contenedor base que define el fondo y el tamaño
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el tamaño de la pantalla
                .statusBarsPadding() // Agrega espacio para evitar la barra de estado
                .padding( // Aplica padding lateral seguro según la dirección del layout
                    start = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateStartPadding(layoutDirection),
                    end = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateEndPadding(layoutDirection)
                ),
        ) {
            PlantListContent( // Llama al contenido de la lista de plantas
                plants = waterViewModel.plants, // Pasa la lista de plantas del ViewModel
                onScheduleReminder = { waterViewModel.scheduleReminder(it) } // Acción a realizar cuando se elige un recordatorio
            )
        }
    }
}

@Composable
fun PlantListContent(
    plants: List<Plant>, // Lista de plantas a mostrar
    onScheduleReminder: (Reminder) -> Unit, // Función callback para programar un recordatorio
    modifier: Modifier = Modifier // Modificador opcional
) {
    var selectedPlant by rememberSaveable { mutableStateOf(plants[0]) } // Guarda la planta seleccionada en un estado persistente
    var showReminderDialog by rememberSaveable { mutableStateOf(false) } // Guarda si se debe mostrar el diálogo

    LazyColumn( // Lista vertical eficiente
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medium)), // Padding general
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)), // Espaciado entre elementos
        modifier = modifier // Aplica el modificador recibido
    ) {
        items(items = plants) { // Itera sobre la lista de plantas
            PlantListItem( // Dibuja un ítem de planta
                plant = it,
                onItemSelect = { plant -> // Callback al hacer clic en la planta
                    selectedPlant = plant // Actualiza la planta seleccionada
                    showReminderDialog = true // Muestra el diálogo
                },
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho disponible
            )
        }
    }

    if (showReminderDialog) { // Si se debe mostrar el diálogo
        ReminderDialogContent( // Muestra el diálogo para elegir duración del recordatorio
            onDialogDismiss = { showReminderDialog = false }, // Acción al cerrar el diálogo
            plantName = stringResource(selectedPlant.name), // Nombre de la planta seleccionado
            onScheduleReminder = onScheduleReminder // Función para programar recordatorio
        )
    }
}

@Composable
fun PlantListItem(plant: Plant, onItemSelect: (Plant) -> Unit, modifier: Modifier = Modifier) {
    Card(modifier = modifier // Dibuja una tarjeta clickeable
        .clickable { onItemSelect(plant) } // Llama a la función al hacer clic
    ) {
        Column( // Contenedor vertical para los textos
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium)) // Aplica padding interno
                .fillMaxWidth(), // Ocupa todo el ancho disponible
            verticalArrangement = Arrangement.spacedBy(4.dp) // Espacio entre textos
        ) {
            Text( // Muestra el nombre de la planta
                text = stringResource(plant.name),
                modifier = Modifier.fillMaxWidth(),
                style = typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Text(text = stringResource(plant.type), style = typography.titleMedium) // Tipo de planta
            Text(text = stringResource(plant.description), style = typography.titleMedium) // Descripción
            Text( // Frecuencia de riego
                text = "${stringResource(R.string.water)} ${stringResource(plant.schedule)}",
                style = typography.titleMedium
            )
        }
    }
}

@Composable
fun ReminderDialogContent(
    onDialogDismiss: () -> Unit, // Función al cerrar el diálogo
    plantName: String, // Nombre de la planta
    onScheduleReminder: (Reminder) -> Unit, // Función para programar recordatorio
    modifier: Modifier = Modifier // Modificador opcional
) {
    val reminders = listOf( // Lista de posibles recordatorios
        Reminder(R.string.five_seconds, FIVE_SECONDS, TimeUnit.SECONDS, plantName),
        Reminder(R.string.one_day, ONE_DAY, TimeUnit.DAYS, plantName),
        Reminder(R.string.one_week, SEVEN_DAYS, TimeUnit.DAYS, plantName),
        Reminder(R.string.one_month, THIRTY_DAYS, TimeUnit.DAYS, plantName)
    )

    AlertDialog( // Diálogo de selección de recordatorio
        onDismissRequest = { onDialogDismiss() }, // Se ejecuta al presionar fuera del diálogo
        confirmButton = {}, // No se necesita botón de confirmación
        title = { Text(stringResource(R.string.remind_me, plantName)) }, // Título del diálogo
        text = {
            Column { // Muestra la lista de opciones de tiempo
                reminders.forEach {
                    Text(
                        text = stringResource(it.durationRes),
                        modifier = Modifier
                            .clickable {
                                onScheduleReminder(it) // Llama a la función con el recordatorio
                                onDialogDismiss() // Cierra el diálogo
                            }
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PlantListItemPreview() {
    WaterMeTheme {
        PlantListItem(DataSource.plants[0], {}) // Previsualiza un ítem de planta
    }
}

@Preview(showBackground = true)
@Composable
fun PlantListContentPreview() {
    PlantListContent(plants = DataSource.plants, onScheduleReminder = {}) // Previsualiza la lista de plantas
}