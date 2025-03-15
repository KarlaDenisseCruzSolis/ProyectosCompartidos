
package com.example.pruebagemini
// Paquete que contiene la clase MainActivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
// Importa las clases necesarias para la funcionalidad de la aplicación

class MainActivity : AppCompatActivity() {  // Define la clase MainActivity que hereda de AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) { // Metodo que se ejecuta cuando la actividad se crea por primera vez
        super.onCreate(savedInstanceState)  // Llama al metodo de la clase padre para inicializar la actividad
        setContentView(R.layout.activity_main)  // Asocia el archivo de diseño activity_main.xml con esta actividad

        // Encuentra las vistas en el layout
        val myTextView: TextView = findViewById(R.id.myTextView) // Asocia el TextView con el ID definido en el archivo XML
        val myButton: Button = findViewById(R.id.myButton)  // Asocia el Button con el ID definido en el archivo XML

        // Establece el texto inicial del TextView
        myTextView.text = "Texto Inicial"

        // Establece el listener para el botón
        myButton.setOnClickListener {
            // Cambia el texto del TextView al hacer clic en el botón
            myTextView.text = "Texto Cambiado"
        }
    }
}