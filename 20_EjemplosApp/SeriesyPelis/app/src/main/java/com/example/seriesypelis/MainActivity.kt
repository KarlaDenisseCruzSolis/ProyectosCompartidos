package com.example.seriesypelis

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var btnAgregar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SerieAdapter
    private lateinit var sharedPreferences: SharedPreferences

    private val listaSeries = mutableListOf<Serie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        btnAgregar = findViewById(R.id.btnAgregar)
        recyclerView = findViewById(R.id.recyclerView)

        sharedPreferences = getSharedPreferences("SeriesPrefs", Context.MODE_PRIVATE)
        cargarSeries()

        // Configurar RecyclerView
        adapter = SerieAdapter(listaSeries, this::mostrarOpciones)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isNotEmpty()) {
                listaSeries.add(Serie(nombre, false))
                adapter.notifyDataSetChanged()
                guardarSeries()
                etNombre.text.clear()
            } else {
                Toast.makeText(this, "Ingresa un nombre válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun mostrarOpciones(serie: Serie) {
        val opciones = arrayOf("Marcar como vista", "Eliminar")
        AlertDialog.Builder(this)
            .setTitle(serie.nombre)
            .setItems(opciones) { _, which ->
                when (which) {
                    0 -> {
                        serie.visto = true
                        adapter.notifyDataSetChanged()
                        guardarSeries()
                    }
                    1 -> {
                        listaSeries.remove(serie)
                        adapter.notifyDataSetChanged()
                        guardarSeries()
                    }
                }
            }
            .show()
    }

    private fun guardarSeries() {
        val editor = sharedPreferences.edit()
        val json = Gson().toJson(listaSeries)
        editor.putString("series", json)
        editor.apply()
    }

    private fun cargarSeries() {
        val json = sharedPreferences.getString("series", null)
        if (!json.isNullOrEmpty()) {
            val type = object : TypeToken<MutableList<Serie>>() {}.type
            listaSeries.addAll(Gson().fromJson(json, type))
        }
    }
}
