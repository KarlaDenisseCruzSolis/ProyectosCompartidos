package com.example.ejemplo9

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var validateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        emailEditText = findViewById(R.id.emailEditText)
        validateButton = findViewById(R.id.validateButton)
        resultTextView = findViewById(R.id.resultTextView)

        // Establecer el listener de clics para el botón
        validateButton.setOnClickListener {
            validateEmail()
        }
    }

    private fun validateEmail() {
        val email = emailEditText.text.toString().trim()

        if (email.isEmpty()) {
            resultTextView.text = "Por favor ingresa una dirección de correo electrónico."
        } else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            resultTextView.text = "La dirección de correo electrónico es válida."
        } else {
            resultTextView.text = "La dirección de correo electrónico no es válida."
        }
    }
}