package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.text
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var btnHola: Button
    private lateinit var tvGreeting: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHola = findViewById(R.id.btnHola)
        tvGreeting = findViewById(R.id.tvGreeting)

        btnHola.setOnClickListener {
            val greeting = getGreeting()
            tvGreeting.text = greeting
        }
    }

    private fun getGreeting(): String {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        return when (hour) {
            in 6..11 -> "Buenos días"
            in 12..20 -> "Buenas tardes"
            else -> "Buenas noches"
        }
    }
}