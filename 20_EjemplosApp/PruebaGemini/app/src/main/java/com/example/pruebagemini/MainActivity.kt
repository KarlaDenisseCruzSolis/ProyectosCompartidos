
package com.example.pruebagemini

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra las vistas en el layout
        val myTextView: TextView = findViewById(R.id.myTextView)
        val myButton: Button = findViewById(R.id.myButton)

        // Establece el texto inicial del TextView
        myTextView.text = "Texto Inicial"

        // Establece el listener para el botón
        myButton.setOnClickListener {
            // Cambia el texto del TextView al hacer clic en el botón
            myTextView.text = "Texto Cambiado"
        }
    }
}