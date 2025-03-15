package com.example.ejemplo3 // Paquete que contiene la clase MainActivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text
// Importación de las clases necesarias para la funcionalidad de la aplicación

class MainActivity : AppCompatActivity() {  // Define la clase MainActivity que hereda de AppCompatActivity

    private var counter = 0 // Variable que almacena el valor del contador (inicia en 0)
    private lateinit var counterTextView: TextView  // Declaración de una variable para el TextView que mostrará el valor del contador
    private lateinit var incrementButton: Button // Declaración de una variable para el botón que incrementará el contador

    override fun onCreate(savedInstanceState: Bundle?) { // Metodo que se ejecuta cuando la actividad se crea por primera vez
        super.onCreate(savedInstanceState) // Llama al metodo de la clase padre para inicializar la actividad
        setContentView(R.layout.activity_main)  // Asocia el archivo de diseño activity_main.xml con esta actividad

        // Inicializar vistas
        counterTextView = findViewById(R.id.counterTextView) // Asocia el TextView con el ID definido en el archivo XML
        incrementButton = findViewById(R.id.incrementButton) // Asocia el Button con el ID definido en el archivo XML

        // Establecer valor inicial del contador
        updateCounterText() // Llama al metodo para mostrar el valor inicial del contador en el TextView

        // Establecer listener de clic para el botón
        incrementButton.setOnClickListener { // Define una acción que se ejecutará al hacer clic en el botón
            incrementCounter()  // Llama al metodo para incrementar el contador
        }
    }

    // Metodo para incrementar el contador
    private fun incrementCounter() {
        counter++ // Incrementa el valor del contador en 1
        updateCounterText() // Llama al metodo para actualizar el valor mostrado en el TextView
    }

    // Metodo para actualizar el valor mostrado en el TextView
    private fun updateCounterText() {
        counterTextView.text = counter.toString() // Convierte el valor del contador a String y lo muestra en el TextView
    }
}