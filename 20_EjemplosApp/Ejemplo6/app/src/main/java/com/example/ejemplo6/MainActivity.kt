package com.example.ejemplo6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var generateButton: Button
    private lateinit var numberTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        generateButton = findViewById(R.id.generateButton)
        numberTextView = findViewById(R.id.numberTextView)

        // Establecer listener de clic para el botón
        generateButton.setOnClickListener {
            generateRandomNumber()
        }
    }

    private fun generateRandomNumber() {
        // Generar un número aleatorio entre 1 y 100 (incluyente)
        val randomNumber = Random.nextInt(1, 101)

        // Mostrar el número aleatorio en el TextView
        numberTextView.text = "Random Number: $randomNumber"
    }
}