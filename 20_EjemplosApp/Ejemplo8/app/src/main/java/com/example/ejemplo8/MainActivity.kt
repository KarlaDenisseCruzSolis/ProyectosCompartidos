package com.example.ejemplo8 // Define el paquete donde se encuentra el archivo

import android.graphics.Color // Importa la clase Color, usada para manipular colores
import android.os.Bundle // Importa la clase Bundle, usada para almacenar información en actividades
import android.widget.Button // Importa la clase Button para crear botones en la interfaz
import android.widget.TextView // Importa la clase TextView para mostrar texto en la interfaz
import androidx.appcompat.app.AppCompatActivity // Importa la clase base para actividades en Android
import androidx.compose.ui.layout.layout

class MainActivity : AppCompatActivity() { // Define la actividad principal de la aplicación

    private lateinit var myTextView: TextView // Declara la variable para el TextView que mostrará el texto
    private lateinit var changeColorButton: Button // Declara la variable para el botón que cambiará el color del texto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        myTextView = findViewById(R.id.myTextView) // Inicializa el TextView para mostrar texto
        changeColorButton = findViewById(R.id.changeColorButton) // Inicializa el botón que cambiará el color del texto

        // Establecer el listener de clics para el botón
        changeColorButton.setOnClickListener { // Cuando el usuario hace clic en el botón
            changeTextColorToRed() // Llama a la función para cambiar el color del texto
        }
    }

    private fun changeTextColorToRed() { // Función que cambia el color del texto a rojo
        // Cambiar el color del texto a rojo
        myTextView.setTextColor(Color.RED)  // Cambia el color del texto en el TextView a rojo
    }
}