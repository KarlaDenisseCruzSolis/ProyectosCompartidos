package com.example.ejemplo6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // Declaración de variables para las vistas
    private lateinit var generateButton: Button // Botón para generar el número aleatorio
    private lateinit var numberTextView: TextView // TextView para mostrar el número aleatorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el layout de la actividad

        // Inicializar vistas mediante los identificadores de los elementos en el layout
        generateButton = findViewById(R.id.generateButton)
        numberTextView = findViewById(R.id.numberTextView)

        // Establecer listener de clic para el botón
        generateButton.setOnClickListener {
            generateRandomNumber() // Llama a la función para generar un número aleatorio cuando se hace clic en el botón
        }
    }

    // Función para generar un número aleatorio
    private fun generateRandomNumber() {
        // Generar un número aleatorio entre 1 y 100 (incluyente)
        val randomNumber = Random.nextInt(1, 101)

        // Mostrar el número aleatorio en el TextView
        numberTextView.text = "Random Number: $randomNumber"
    }
}