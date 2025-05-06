package com.lixoten.flightsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lixoten.flightsearch.ui.theme.FlightSearchTheme

class MainActivity : ComponentActivity() { // Clase principal de la app, hereda de ComponentActivity para usar Jetpack Compose.
    override fun onCreate(savedInstanceState: Bundle?) { // Metodo que se ejecuta al crear la actividad.
        super.onCreate(savedInstanceState) // Llama a la implementación del metodo en la superclase.
        setContent { // Define el contenido de la actividad usando composables.
            FlightSearchTheme { // Aplica el tema personalizado a toda la jerarquía de UI.
                // A surface container using the 'background' color from the theme
                Surface( // Contenedor visual con estilo, siguiendo el diseño Material.
                    modifier = Modifier.fillMaxSize(), // Hace que la superficie ocupe todo el tamaño de la pantalla.
                    color = MaterialTheme.colors.background // Usa el color de fondo definido en el tema actual.
                ) {
                    FlightSearchApp() // Llama al composable principal de la app, que contiene la lógica de la interfaz.
                }
            }
        }
    }
}