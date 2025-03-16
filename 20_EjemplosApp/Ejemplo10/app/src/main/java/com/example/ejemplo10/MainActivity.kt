package com.example.ejemplo10 // Define el paquete donde se encuentra el archivo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class MainActivity : AppCompatActivity() {

    private lateinit var timeTextView: TextView // Declara la variable para el TextView que mostrará la hora
    private lateinit var showTimeButton: Button  // Declara la variable para el botón que muestra la hora actual

    override fun onCreate(savedInstanceState: Bundle?) { // Metodo llamado cuando la actividad es creada
        super.onCreate(savedInstanceState)  // Llama al constructor de la clase base
        setContentView(R.layout.activity_main) // Establece el layout de la actividad

        // Inicializar vistas
        timeTextView = findViewById(R.id.timeTextView) // Inicializa el TextView para mostrar la hora
        showTimeButton = findViewById(R.id.showTimeButton) // Inicializa el botón para mostrar la hora

        // Establecer el listener de clics para el botón
        showTimeButton.setOnClickListener { // Cuando el usuario hace clic en el botón
            showCurrentTime() // Llama a la función para mostrar la hora actual
        }
    }
    // Función que obtiene y muestra la hora actual
    private fun showCurrentTime() {
        val currentTime = Calendar.getInstance() // Obtiene una instancia de Calendar con la hora actual
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault()) // Define el formato de hora (horas, minutos, segundos)

        // Configurar la zona horaria del dispositivo
        timeFormat.timeZone = TimeZone.getDefault()

        val formattedTime = timeFormat.format(currentTime.time) // Formatea la hora actual según el formato definido
        timeTextView.text = "Hora actual: $formattedTime" // Muestra la hora formateada en el TextView
    }
}