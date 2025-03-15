package com.example.ejemplo5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText // Campo de texto para el primer número
    private lateinit var number2EditText: EditText // Campo de texto para el segundo número
    private lateinit var addButton: Button // Botón para realizar la suma
    private lateinit var resultTextView: TextView // TextView para mostrar el resultado de la suma

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Establece el layout de la actividad

        // Inicializar vistas
        // Inicialización de vistas mediante los identificadores de los elementos en el layout
        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        addButton = findViewById(R.id.addButton)
        resultTextView = findViewById(R.id.resultTextView)

        // Establecer listener de clic para el botón de suma
        addButton.setOnClickListener {
            calculateSum()  // Llama a la función para calcular la suma cuando se hace clic en el botón
        }
    }

    private fun calculateSum() {
        // Obtener los valores ingresados por el usuario como cadenas
        val number1String = number1EditText.text.toString()
        val number2String = number2EditText.text.toString()

        // Verifica si algún campo está vacío
        if (number1String.isEmpty() || number2String.isEmpty()) {
            resultTextView.text = "Error: Por favor ingrese ambos números."
            return
        }

        try {
            // Intenta convertir las cadenas a números
            val number1 = number1String.toDouble()
            val number2 = number2String.toDouble()
            val sum = number1 + number2 // Realiza la suma de los números
            resultTextView.text = "Resultado: $sum" // Muestra el resultado de la suma
        } catch (e: NumberFormatException) {
            // Si ocurre un error de formato (por ejemplo, si el usuario ingresa texto en lugar de números)
            resultTextView.text = "Error: Entrada inválida. Por favor ingrese solo números." // Muestra un mensaje de error
        }
    }
}