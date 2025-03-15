package com.example.ejemplo2
// Paquete que contiene la clase MainActivity

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random
// Importación de las clases necesarias para la funcionalidad de la aplicación

class MainActivity : AppCompatActivity() { // Define la clase MainActivity que hereda de AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {  // Metodo que se ejecuta cuando la actividad se crea por primera vez
        super.onCreate(savedInstanceState) // Llama al metodo de la clase padre para inicializar la actividad
        setContentView(R.layout.activity_main) // Asocia el archivo de diseño activity_main.xml con esta actividad

        // Obtener referencias al diseño y al botón
        val mainLayout: ConstraintLayout = findViewById(R.id.mainLayout) // Asocia el ConstraintLayout con el ID definido en el archivo XML
        val changeColorButton: Button = findViewById(R.id.changeColorButton) // Asocia el Button con el ID definido en el archivo XML

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
        val random = Random() // Crea una nueva instancia de la clase Random
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)) // Canal alfa (opacidad) completamente visible, Valor de rojo entre 0 y 255, Valor de verde entre 0 y 255,Valor de azul entre 0 y 255.
    }
}