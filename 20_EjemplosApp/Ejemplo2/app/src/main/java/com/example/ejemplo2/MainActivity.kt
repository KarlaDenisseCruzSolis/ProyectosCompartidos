package com.example.ejemplo2

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencias al diseño y al botón
        val mainLayout: ConstraintLayout = findViewById(R.id.mainLayout)
        val changeColorButton: Button = findViewById(R.id.changeColorButton)

        // Establecer un listener de clic para el botón
        changeColorButton.setOnClickListener {
            // Generar un color aleatorio
            val randomColor = getRandomColor()

            // Cambiar el color de fondo del diseño
            mainLayout.setBackgroundColor(randomColor)
        }
    }

    // Función para generar un color aleatorio
    private fun getRandomColor(): Int {
        val random = Random()
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}