package com.example.ejemplo10

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

    private lateinit var timeTextView: TextView
    private lateinit var showTimeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        timeTextView = findViewById(R.id.timeTextView)
        showTimeButton = findViewById(R.id.showTimeButton)

        // Establecer el listener de clics para el botón
        showTimeButton.setOnClickListener {
            showCurrentTime()
        }
    }

    private fun showCurrentTime() {
        val currentTime = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        // Configurar la zona horaria del dispositivo
        timeFormat.timeZone = TimeZone.getDefault()

        val formattedTime = timeFormat.format(currentTime.time)
        timeTextView.text = "Hora actual: $formattedTime"
    }
}