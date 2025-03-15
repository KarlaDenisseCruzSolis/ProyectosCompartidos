package com.example.ejemplo4 // Paquete que contiene la clase MainActivity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.text
// Importación de las clases necesarias para la funcionalidad de la aplicación

class MainActivity : AppCompatActivity() { // Define la clase MainActivity que hereda de AppCompatActivity

    private lateinit var taskEditText: EditText // Declaración de la variable para el EditText donde el usuario ingresará la tarea
    private lateinit var addButton: Button // Declaración de la variable para el botón que agregará la tarea
    private lateinit var taskListView: ListView // Declaración de la variable para la ListView donde se mostrarán las tareas
    private lateinit var taskList: MutableList<String> // Declaración de una lista mutable para almacenar las tareas
    private lateinit var adapter: ArrayAdapter<String> // Declaración de un adaptador que conecta la lista con la ListView

    override fun onCreate(savedInstanceState: Bundle?) { // Metodo que se ejecuta cuando la actividad se crea por primera vez
        super.onCreate(savedInstanceState) // Llama al metodo de la clase padre para inicializar la actividad
        setContentView(R.layout.activity_main)  // Asocia el archivo de diseño activity_main.xml con esta actividad

        // Inicializar vistas
        taskEditText = findViewById(R.id.taskEditText) // Asocia el EditText con el ID definido en el archivo XML
        addButton = findViewById(R.id.addButton) // Asocia el Button con el ID definido en el archivo XML
        taskListView = findViewById(R.id.taskListView) // Asocia el ListView con el ID definido en el archivo XML

        // Inicializar lista de tareas y adaptador
        taskList = mutableListOf() // Crea una lista mutable vacía para las tareas
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)  // Crea un adaptador para la ListView con un diseño simple de texto
        taskListView.adapter = adapter // Asocia el adaptador a la ListView para mostrar las tareas

        // Establecer listener de clic para el botón de agregar
        addButton.setOnClickListener { // Define una acción que se ejecutará al hacer clic en el botón
            addTask() // Llama al metodo addTask para agregar la tarea a la lista
        }

        // Establecer listener de clic para los elementos de la lista
        taskListView.setOnItemClickListener { _, _, position, _ -> // Define una acción que se ejecutará al hacer clic en un elemento de la lista
            removeTask(position) // Llama al metodo removeTask para eliminar la tarea de la lista
        }
    }

    private fun addTask() {
        val task = taskEditText.text.toString().trim() // Obtiene el texto ingresado en el EditText y elimina los espacios en blanco
        if (task.isNotEmpty()) { // Verifica si la tarea no está vacía
            taskList.add(task) // Agrega la tarea a la lista de tareas
            adapter.notifyDataSetChanged() // Notifica al adaptador que la lista ha cambiado para actualizar la vista
            taskEditText.text.clear() // Limpia el contenido del EditText después de agregar la tarea
        }
    }

    // Metodo para eliminar una tarea de la lista
    private fun removeTask(position: Int) {
        taskList.removeAt(position) // Elimina la tarea en la posición dada
        adapter.notifyDataSetChanged() // Notifica al adaptador que la lista ha cambiado para actualizar la vista
    }
}