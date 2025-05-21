/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.waterme.worker // Define el paquete donde se encuentra esta clase Worker

import android.content.Context // Importa la clase Context, necesaria para acceder a recursos del sistema Android
import androidx.work.CoroutineWorker // Importa la clase base para workers que usan corrutinas
import androidx.work.WorkerParameters // Importa los parámetros que necesita el worker (como entrada, tiempo, etc.)
import com.example.waterme.R // Importa el archivo de recursos para acceder a strings, layouts, etc.

// Define una clase llamada WaterReminderWorker que extiende CoroutineWorker, usada para ejecutar tareas en segundo plano
class WaterReminderWorker(
    context: Context, // Recibe el contexto de la aplicación
    workerParams: WorkerParameters // Recibe los parámetros para configurar el worker
) : CoroutineWorker(context, workerParams) { // Llama al constructor de la superclase CoroutineWorker
    // Sobrescribe la función doWork(), que define lo que el worker hará cuando se ejecute
    override suspend fun doWork(): Result {
        val plantName = inputData.getString(nameKey)
        // Obtiene el nombre de la planta desde los datos de entrada del worker usando la clave "NAME"
        makePlantReminderNotification(
            applicationContext.resources.getString(R.string.time_to_water, plantName),
            applicationContext
        )
        // Llama a una función personalizada (debes tenerla definida en otro archivo) que muestra una notificación con el mensaje
        // El mensaje se obtiene desde el recurso `R.string.time_to_water` formateado con el nombre de la planta
        return Result.success()
        // Retorna un resultado exitoso, indicando que el trabajo se ejecutó correctamente
    }
    companion object { // Define un objeto companion para crear constantes estáticas
        const val nameKey = "NAME"
        // Clave usada para acceder al nombre de la planta dentro de los datos de entrada
    }
}