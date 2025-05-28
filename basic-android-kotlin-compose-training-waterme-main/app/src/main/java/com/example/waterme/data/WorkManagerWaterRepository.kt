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

package com.example.waterme.data // Define el paquete donde se encuentra esta clase.

import android.content.Context // Importa la clase Context de Android, necesaria para obtener instancias del sistema.
import androidx.work.Data // Importa la clase Data para pasar datos a los workers.
import androidx.work.ExistingWorkPolicy // Define cómo manejar trabajos existentes con el mismo nombre.
import androidx.work.OneTimeWorkRequestBuilder // Permite construir una solicitud de trabajo única.
import androidx.work.WorkManager // Clase principal para manejar trabajos en segundo plano.
import com.example.waterme.model.Plant // Importa el modelo de datos Plant.
import com.example.waterme.worker.WaterReminderWorker // Importa el worker que se encargará de enviar el recordatorio.
import java.util.concurrent.TimeUnit // Importa la unidad de tiempo para el retraso del trabajo.

class WorkManagerWaterRepository(context: Context) : WaterRepository { // Implementa la interfaz WaterRepository utilizando WorkManager.
    private val workManager = WorkManager.getInstance(context) // Obtiene una instancia de WorkManager con el contexto de la app.

    override val plants: List<Plant> // Implementa la propiedad `plants` requerida por la interfaz.
        get() = DataSource.plants // Devuelve la lista de plantas desde el objeto de datos simulado `DataSource`.

    override fun scheduleReminder(duration: Long, unit: TimeUnit, plantName: String) { // Implementa el método para agendar un recordatorio.
        val data = Data.Builder() // Crea un constructor de datos para pasar al worker.
        data.putString(WaterReminderWorker.nameKey, plantName) // Inserta el nombre de la planta como dato para el worker.

        val workRequestBuilder = OneTimeWorkRequestBuilder<WaterReminderWorker>() // Crea una solicitud de trabajo única.
            .setInitialDelay(duration, unit) // Establece un retraso inicial para ejecutar el worker después del tiempo especificado.
            .setInputData(data.build()) // Añade los datos creados anteriormente a la solicitud.
            .build() // Construye la solicitud de trabajo.

        workManager.enqueueUniqueWork( // Encola el trabajo único en el WorkManager.
            plantName + duration, // Nombre único del trabajo (plantName + duración) para evitar duplicados.
            ExistingWorkPolicy.REPLACE, // Si ya existe un trabajo con ese nombre, lo reemplaza.
            workRequestBuilder // Solicitud de trabajo a ejecutar.
        )
    }
}