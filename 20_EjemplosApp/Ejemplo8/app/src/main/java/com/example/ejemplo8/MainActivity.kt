package com.example.ejemplo8

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView: TextView
    private lateinit var changeColorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        myTextView = findViewById(R.id.myTextView)
        changeColorButton = findViewById(R.id.changeColorButton)

        // Establecer el listener de clics para el botón
        changeColorButton.setOnClickListener {
            changeTextColorToRed()
        }
    }

    private fun changeTextColorToRed() {
        // Cambiar el color del texto a rojo
        myTextView.setTextColor(Color.RED)
    }
}