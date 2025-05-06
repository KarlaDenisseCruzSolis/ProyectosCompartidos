/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sqlbasics // Declaración del paquete donde se encuentra esta clase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() { // Define la clase principal de la actividad
    override fun onCreate(savedInstanceState: Bundle?) { // Metodo que se llama cuando la actividad se crea
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el diseño XML de la interfaz gráfica de esta actividad
        // Don't do this in a production app
        // Advertencia: No se recomienda usar GlobalScope en producción
        // Se lanza una corrutina para acceder a la base de datos
        GlobalScope.launch {
            // Llama al DAO (Data Access Object) para obtener todos los parques
            AppDatabase.getDatabase(applicationContext).californiaParkDao().getAll()
        }
    }
}
