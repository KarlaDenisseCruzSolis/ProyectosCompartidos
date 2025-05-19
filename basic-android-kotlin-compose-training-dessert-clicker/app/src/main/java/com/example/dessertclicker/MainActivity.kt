/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dessertclicker

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.ui.theme.DessertClickerTheme

// Tag for logging
// Tag para los logs de depuración
private const val TAG = "MainActivity"

// Clase principal que hereda de ComponentActivity para usar Compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Activa el diseño de pantalla completa Edge-to-Edge
        super.onCreate(savedInstanceState)  // Llama a onCreate padre
        Log.d(TAG, "onCreate Called")  // Log de depuración
        setContent {
            DessertClickerTheme {  // Aplica el tema de la app
                Surface(
                    modifier = Modifier
                        .fillMaxSize()  // Ocupa toda la pantalla
                        .statusBarsPadding(), // Padding para no tapar la barra de estado
                ) {
                    DessertClickerApp(desserts = Datasource.dessertList) // Lanza la app con datos de postres
                }
            }
        }
    }

    // Métodos del ciclo de vida con logs para depuración

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}

/**
 * Función para determinar qué postre mostrar según la cantidad vendida.
 * @param desserts Lista ordenada de postres disponibles.
 * @param dessertsSold Cantidad de postres vendidos hasta ahora.
 * @return El postre correspondiente para mostrar.
 */
fun determineDessertToShow(
    desserts: List<Dessert>,
    dessertsSold: Int
): Dessert {
    var dessertToShow = desserts.first() // Inicialmente selecciona el primer postre
    for (dessert in desserts) {
        if (dessertsSold >= dessert.startProductionAmount) {
            dessertToShow = dessert  // Actualiza el postre a mostrar si cumple la cantidad mínima
        } else {
            break  // Sale del ciclo ya que la lista está ordenada
        }
    }

    return dessertToShow // Devuelve el postre seleccionado
}

/**
 * Función para compartir información sobre postres vendidos e ingresos.
 * @param intentContext Contexto para crear el Intent
 * @param dessertsSold Cantidad total de postres vendidos
 * @param revenue Ingresos acumulados
 */
private fun shareSoldDessertsInformation(intentContext: Context, dessertsSold: Int, revenue: Int) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND  // Intent para enviar texto
        putExtra(
            Intent.EXTRA_TEXT,
            intentContext.getString(R.string.share_text, dessertsSold, revenue) // Texto a compartir formateado
        )
        type = "text/plain"  // Tipo MIME del contenido
    }

    val shareIntent = Intent.createChooser(sendIntent, null)  // Crea selector para apps compatibles

    try {
        ContextCompat.startActivity(intentContext, shareIntent, null)  // Intenta lanzar la actividad de compartir
    } catch (e: ActivityNotFoundException) {
        // Si no hay app compatible, muestra mensaje
        Toast.makeText(
            intentContext,
            intentContext.getString(R.string.sharing_not_available),
            Toast.LENGTH_LONG
        ).show()
    }
}

@Composable
private fun DessertClickerApp(
    desserts: List<Dessert>
) {
    // Variables de estado para ingresos, postres vendidos y detalles del postre actual
    var revenue by rememberSaveable { mutableStateOf(0) }
    var dessertsSold by rememberSaveable { mutableStateOf(0) }

    val currentDessertIndex by rememberSaveable { mutableStateOf(0) }

    var currentDessertPrice by rememberSaveable {
        mutableStateOf(desserts[currentDessertIndex].price)
    }
    var currentDessertImageId by rememberSaveable {
        mutableStateOf(desserts[currentDessertIndex].imageId)
    }

    Scaffold(// Scaffold para diseño básico con barra superior
        topBar = {
            val intentContext = LocalContext.current// Contexto para compartir
            val layoutDirection = LocalLayoutDirection.current // Dirección LTR/RTL
            DessertClickerAppBar(
                onShareButtonClicked = {// Evento para compartir cuando se presiona el botón
                    shareSoldDessertsInformation(
                        intentContext = intentContext,
                        dessertsSold = dessertsSold,
                        revenue = revenue
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = WindowInsets.safeDrawing.asPaddingValues()
                            .calculateStartPadding(layoutDirection),
                        end = WindowInsets.safeDrawing.asPaddingValues()
                            .calculateEndPadding(layoutDirection),
                    )
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    ) { contentPadding ->
        DessertClickerScreen(
            revenue = revenue,
            dessertsSold = dessertsSold,
            dessertImageId = currentDessertImageId,
            onDessertClicked = {

                // Update the revenue
                revenue += currentDessertPrice// Aumenta ingresos al vender
                dessertsSold++// Incrementa cantidad vendida

                // Actualiza el postre a mostrar según la cantidad vendida
                val dessertToShow = determineDessertToShow(desserts, dessertsSold)
                currentDessertImageId = dessertToShow.imageId
                currentDessertPrice = dessertToShow.price
            },
            modifier = Modifier.padding(contentPadding)
        )
    }
}

@Composable
private fun DessertClickerAppBar(
    onShareButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,  // Aplica el modificador recibido
        horizontalArrangement = Arrangement.SpaceBetween,  // Separa elementos a los extremos horizontalmente
        verticalAlignment = Alignment.CenterVertically,  // Centra verticalmente los elementos en la fila
    ) {
        Text(
            text = stringResource(R.string.app_name),  // Texto con el nombre de la app (recuperado de recursos)
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium)),  // Padding a la izquierda
            color = MaterialTheme.colorScheme.onPrimary,  // Color del texto según el tema, para que contraste con fondo primario
            style = MaterialTheme.typography.titleLarge,  // Estilo de texto grande para títulos
        )
        IconButton(
            onClick = onShareButtonClicked,  // Acción al presionar el botón (compartir)
            modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_medium)),  // Padding a la derecha
        ) {
            Icon(
                imageVector = Icons.Filled.Share,  // Icono de compartir
                contentDescription = stringResource(R.string.share),  // Texto accesible para lectores de pantalla
                tint = MaterialTheme.colorScheme.onPrimary  // Color del icono para que contraste con fondo primario
            )
        }
    }
}

@Composable
fun DessertClickerScreen(
    revenue: Int,
    dessertsSold: Int,
    @DrawableRes dessertImageId: Int,
    onDessertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {  // Contenedor base que permite superposición de elementos
        Image(
            painter = painterResource(R.drawable.bakery_back),  // Imagen de fondo (panadería)
            contentDescription = null,  // No se proporciona descripción accesible porque es decorativa
            contentScale = ContentScale.Crop  // Escala para cubrir todo el espacio sin distorsión
        )
        Column {  // Contenedor vertical para colocar imagen y datos uno debajo de otro
            Box(
                modifier = Modifier
                    .weight(1f)  // Ocupa todo el espacio disponible verticalmente
                    .fillMaxWidth(),  // Ancho completo
            ) {
                Image(
                    painter = painterResource(dessertImageId),  // Imagen del postre actual
                    contentDescription = null,  // Descripción accesible no definida, se puede agregar si se desea
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.image_size))  // Ancho fijo según recurso de dimensión
                        .height(dimensionResource(R.dimen.image_size))  // Altura fija según recurso
                        .align(Alignment.Center)  // Centra la imagen dentro del Box
                        .clickable { onDessertClicked() },  // Acción al tocar la imagen
                    contentScale = ContentScale.Crop,  // Escala la imagen para cubrir su área sin distorsión
                )
            }
            TransactionInfo(
                revenue = revenue,  // Pasa ingresos
                dessertsSold = dessertsSold,  // Pasa cantidad vendida
                modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer)  // Fondo para la info
            )
        }
    }
}

@Composable
private fun TransactionInfo(
    revenue: Int,
    dessertsSold: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {  // Columna para poner datos verticalmente
        DessertsSoldInfo(
            dessertsSold = dessertsSold,  // Cantidad de postres vendidos
            modifier = Modifier
                .fillMaxWidth()  // Ancho completo
                .padding(dimensionResource(R.dimen.padding_medium))  // Padding interno
        )
        RevenueInfo(
            revenue = revenue,  // Ingresos totales
            modifier = Modifier
                .fillMaxWidth()  // Ancho completo
                .padding(dimensionResource(R.dimen.padding_medium))  // Padding interno
        )
    }
}

@Composable
private fun RevenueInfo(revenue: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,  // Aplica modificador recibido
        horizontalArrangement = Arrangement.SpaceBetween,  // Separa elementos a los extremos horizontalmente
    ) {
        Text(
            text = stringResource(R.string.total_revenue),  // Texto "Total Revenue"
            style = MaterialTheme.typography.headlineMedium,  // Estilo de texto para encabezado mediano
            color = MaterialTheme.colorScheme.onSecondaryContainer  // Color del texto para que contraste con fondo secundario
        )
        Text(
            text = "$${revenue}",  // Muestra la cantidad de ingresos con símbolo $
            textAlign = TextAlign.Right,  // Texto alineado a la derecha
            style = MaterialTheme.typography.headlineMedium,  // Mismo estilo que el título
            color = MaterialTheme.colorScheme.onSecondaryContainer  // Color consistente con título
        )
    }
}

@Composable
private fun DessertsSoldInfo(dessertsSold: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,  // Aplica modificador recibido
        horizontalArrangement = Arrangement.SpaceBetween,  // Separa elementos a los extremos
    ) {
        Text(
            text = stringResource(R.string.dessert_sold),  // Texto "Desserts Sold"
            style = MaterialTheme.typography.titleLarge,  // Estilo de texto grande para títulos
            color = MaterialTheme.colorScheme.onSecondaryContainer  // Color que contraste con fondo secundario
        )
        Text(
            text = dessertsSold.toString(),  // Muestra la cantidad vendida en texto
            style = MaterialTheme.typography.titleLarge,  // Mismo estilo que el título
            color = MaterialTheme.colorScheme.onSecondaryContainer  // Color consistente
        )
    }
}

@Preview
@Composable
fun MyDessertClickerAppPreview() {
    DessertClickerTheme {
        DessertClickerApp(listOf(Dessert(R.drawable.cupcake, 5, 0)))  // Vista previa con un cupcake y precio 5
    }
}
