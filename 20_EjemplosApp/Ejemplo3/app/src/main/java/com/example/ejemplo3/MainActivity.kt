package com.example.ejemplo3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var counterTextView: TextView
    private lateinit var incrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        counterTextView = findViewById(R.id.counterTextView)
        incrementButton = findViewById(R.id.incrementButton)

        // Establecer valor inicial del contador
        updateCounterText()

        // Establecer listener de clic para el botón
        incrementButton.setOnClickListener {
            incrementCounter()
        }
    }

    private fun incrementCounter() {
        counter++
        updateCounterText()
    }

    private fun updateCounterText() {
        counterTextView.text = counter.toString()
    }
}