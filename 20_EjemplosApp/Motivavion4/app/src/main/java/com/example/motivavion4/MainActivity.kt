package com.example.motivavion4

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Lista de frases motivacionales
    private val frases = listOf(
        "El éxito es la suma de pequeños esfuerzos repetidos cada día.",
        "Cree en ti mismo y todo será posible.",
        "No cuentes los días, haz que los días cuenten.",
        "La disciplina es el puente entre metas y logros.",
        "Nunca es demasiado tarde para ser quien podrías haber sido."
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val fraseTextView: TextView = findViewById(R.id.fraseTextView)
        val botonNuevaFrase: Button = findViewById(R.id.botonNuevaFrase)

        // Asigna una frase inicial
        fraseTextView.text = frases.random()

        // Evento para generar una nueva frase aleatoria
        botonNuevaFrase.setOnClickListener {
            fraseTextView.text = frases.random()
        }
    }
}
