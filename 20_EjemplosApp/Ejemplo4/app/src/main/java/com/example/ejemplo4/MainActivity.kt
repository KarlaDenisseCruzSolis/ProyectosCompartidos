package com.example.ejemplo4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    private lateinit var taskEditText: EditText
    private lateinit var addButton: Button
    private lateinit var taskListView: ListView
    private lateinit var taskList: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        taskEditText = findViewById(R.id.taskEditText)
        addButton = findViewById(R.id.addButton)
        taskListView = findViewById(R.id.taskListView)

        // Inicializar lista de tareas y adaptador
        taskList = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        taskListView.adapter = adapter

        // Establecer listener de clic para el botón de agregar
        addButton.setOnClickListener {
            addTask()
        }

        // Establecer listener de clic para los elementos de la lista
        taskListView.setOnItemClickListener { _, _, position, _ ->
            removeTask(position)
        }
    }

    private fun addTask() {
        val task = taskEditText.text.toString().trim()
        if (task.isNotEmpty()) {
            taskList.add(task)
            adapter.notifyDataSetChanged()
            taskEditText.text.clear()
        }
    }

    private fun removeTask(position: Int) {
        taskList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}