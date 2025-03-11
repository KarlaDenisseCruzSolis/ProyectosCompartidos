package com.example.ejemplo7

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private lateinit var textEditText: EditText
    private lateinit var countButton: Button
    private lateinit var wordCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        textEditText = findViewById(R.id.textEditText)
        countButton = findViewById(R.id.countButton)
        wordCountTextView = findViewById(R.id.wordCountTextView)

        // Establecer listener de clic para el botón
        countButton.setOnClickListener {
            countWords()
        }
    }

    private fun countWords() {
        val text = textEditText.text.toString().trim()

        if (text.isEmpty()) {
            wordCountTextView.text = "Word Count: 0"
        } else {
            val words = text.split("\\s+".toRegex()) // Dividir por uno o más espacios en blanco
            val wordCount = words.size
            wordCountTextView.text = "Word Count: $wordCount"
        }
    }
}