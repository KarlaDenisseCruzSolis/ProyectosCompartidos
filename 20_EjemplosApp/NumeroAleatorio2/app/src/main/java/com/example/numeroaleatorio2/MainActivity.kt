package com.example.numeroaleatorio2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var numeroSecreto = 0
    private lateinit var mensajeTextView: TextView
    private lateinit var numeroEditText: EditText
    private lateinit var adivinarButton: Button
    private lateinit var reiniciarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        mensajeTextView = findViewById(R.id.mensajeTextView)
        numeroEditText = findViewById(R.id.numeroEditText)
        adivinarButton = findViewById(R.id.adivinarButton)
        reiniciarButton = findViewById(R.id.reiniciarButton)

        iniciarJuego()

        adivinarButton.setOnClickListener {
            val numeroUsuario = numeroEditText.text.toString().toIntOrNull()

            if (numeroUsuario == null) {
                Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_SHORT).show()
            } else {
                when {
                    numeroUsuario < numeroSecreto -> mensajeTextView.text = "Más alto!"
                    numeroUsuario > numeroSecreto -> mensajeTextView.text = "Más bajo!"
                    else -> {
                        mensajeTextView.text = "¡Correcto! El número era $numeroSecreto"
                        reiniciarButton.visibility = View.VISIBLE
                    }
                }
            }
        }

        reiniciarButton.setOnClickListener {
            iniciarJuego()
        }
    }

    private fun iniciarJuego() {
        numeroSecreto = Random.nextInt(1, 101)
        mensajeTextView.text = "Adivina un número entre 1 y 100"
        numeroEditText.text.clear()
        reiniciarButton.visibility = View.GONE
    }
}
