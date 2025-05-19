package com.example.webservice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    val lista: MutableList<Categoria> = mutableListOf()
    lateinit var resultado: TextView
    private lateinit var requestQueue: RequestQueue
    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)
        listview = findViewById(R.id.lvCategory)
    }

    fun obtenerProductosDelWebService2(view: View) {
        var usuario: String
        var contrasena: String
        usuario = "jmvm1000@gmail.com"
        contrasena = "1234"

        val url = "http://pruebaslogan.atwebpages.com/get_categories_ws.php"

        // Crear el objeto JSON con los parámetros de usuario y contraseña
        val parametros = JSONObject()
        try {
            parametros.put("usuario", usuario)
            parametros.put("contrasena", contrasena)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        // Crear una solicitud POST con Volley
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            parametros,
            { response ->
                try {
                    val status = response.getString("status")
                    if (status == "success") {
                        val categoriasJson = response.getJSONArray("data")
                        for (i in 0 until categoriasJson.length()) {
                            val productoJson = categoriasJson.getJSONObject(i)
                            val categoria = Categoria(
                                id = productoJson.getInt("id"),
                                nombre = productoJson.getString("nombre_categoria"),
                                descripcion = productoJson.getString("descripcion")
                            )
                            lista.add(categoria)
                        }
                        llenarView()
                    } else {
                        val message = response.getString("message")
                        Toast.makeText(this, "Error: $message", Toast.LENGTH_LONG).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error en la respuesta del servidor", Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                error.printStackTrace()
                Toast.makeText(this, "Error en la solicitud: ${error.message}", Toast.LENGTH_LONG).show()
            }
        )

        // Añadir la solicitud a la cola
        requestQueue.add(request)
    }

    private fun llenarView() {
        val items = mutableListOf<String>()
        for (i in lista) {
            items.add(i.nombre)
        }

        // Configurar el ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        // Asigna el adaptador al ListView
        listview.adapter = adapter
    }
}

data class Categoria(
    val id: Int,
    val nombre: String,
    val descripcion: String,
)