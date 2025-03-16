package com.example.ejemplo7 // Define el paquete donde se encuentra el archivo

import android.os.Bundle // Importa la clase Bundle, usada para almacenar información en actividades
import android.widget.Button // Importa la clase Button para crear botones en la interfaz
import android.widget.EditText // Importa la clase EditText para campos de entrada de texto
import android.widget.TextView // Importa la clase TextView para mostrar texto en la interfaz
import androidx.appcompat.app.AppCompatActivity // Importa la clase base para actividades en Android
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() { // Define la actividad principal de la aplicación

    private lateinit var textEditText: EditText // EditText donde el usuario ingresará el texto
    private lateinit var countButton: Button // Botón que cuenta las palabras
    private lateinit var wordCountTextView: TextView // TextView para mostrar el número de palabras

    override fun onCreate(savedInstanceState: Bundle?) { // Metodo llamado cuando la actividad es creada
        super.onCreate(savedInstanceState) // Llama al constructor de la clase base
        setContentView(R.layout.activity_main) // Establece el layout de la actividad

        // Inicializar vistas
        textEditText = findViewById(R.id.textEditText) // Inicializa el EditText para ingresar texto
        countButton = findViewById(R.id.countButton) // Inicializa el botón que contará las palabras
        wordCountTextView = findViewById(R.id.wordCountTextView) // Inicializa el TextView para mostrar el conteo de palabras

        // Establecer listener de clic para el botón
        countButton.setOnClickListener {  // Cuando el usuario hace clic en el botón
            countWords() // Llama a la función para contar las palabras
        }
    }

    private fun countWords() { // Función que cuenta las palabras en el texto ingresado por el usuario
        val text = textEditText.text.toString().trim() // Obtiene el texto del EditText y elimina espacios al inicio y al final

        if (text.isEmpty()) { // Verifica si el texto está vacío
            wordCountTextView.text = "Word Count: 0" // Si el texto está vacío, muestra 0 palabras
        } else {
            // Divide el texto en palabras usando espacios en blanco como delimitadores
            val words = text.split("\\s+".toRegex()) // Dividir por uno o más espacios en blanco
            val wordCount = words.size // Cuenta cuántas palabras se han generado
            wordCountTextView.text = "Word Count: $wordCount" // Muestra el número de palabras en el TextView
        }
    }
}