package com.example.ejemplo5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var addButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        addButton = findViewById(R.id.addButton)
        resultTextView = findViewById(R.id.resultTextView)

        // Establecer listener de clic para el botón de suma
        addButton.setOnClickListener {
            calculateSum()
        }
    }

    private fun calculateSum() {
        val number1String = number1EditText.text.toString()
        val number2String = number2EditText.text.toString()

        if (number1String.isEmpty() || number2String.isEmpty()) {
            resultTextView.text = "Error: Por favor ingrese ambos números."
            return
        }

        try {
            val number1 = number1String.toDouble()
            val number2 = number2String.toDouble()
            val sum = number1 + number2
            resultTextView.text = "Resultado: $sum"
        } catch (e: NumberFormatException) {
            resultTextView.text = "Error: Entrada inválida. Por favor ingrese solo números."
        }
    }
}