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

package com.example.waterme.worker // Define el paquete donde se encuentra este archivo

// Importaciones necesarias para manejar notificaciones en Android
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

// Importa constantes y recursos necesarios de otras partes del proyecto
import com.example.waterme.CHANNEL_ID
import com.example.waterme.MainActivity
import com.example.waterme.NOTIFICATION_ID
import com.example.waterme.NOTIFICATION_TITLE
import com.example.waterme.R
import com.example.waterme.REQUEST_CODE
import com.example.waterme.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
import com.example.waterme.VERBOSE_NOTIFICATION_CHANNEL_NAME

// Función que muestra la notificación con el mensaje que se le pase
fun makePlantReminderNotification(
    message: String, // Texto del recordatorio, por ejemplo: "¡Es hora de regar la planta Rosa!"
    context: Context // Contexto necesario para acceder a servicios del sistema
) {
    // Solo crear el canal de notificación si el dispositivo tiene Android 8 (API 26) o superior
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_HIGH // Establece la prioridad como alta
        val channel = NotificationChannel(
            CHANNEL_ID, // ID único del canal
            VERBOSE_NOTIFICATION_CHANNEL_NAME, // Nombre visible del canal
            importance // Nivel de importancia
        )
        channel.description = VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION // Descripción del canal
        // Obtiene el servicio de notificaciones del sistema
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager?.createNotificationChannel(channel) // Crea el canal si no existe
    }

    val pendingIntent: PendingIntent = createPendingIntent(context)
    // Crea un PendingIntent que se usará para abrir la app cuando el usuario toque la notificación

    // Construye la notificación usando NotificationCompat
    val builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground) // Ícono que se mostrará en la notificación
        .setContentTitle(NOTIFICATION_TITLE) // Título de la notificación (definido en constantes)
        .setContentText(message) // Mensaje de la notificación (ej. "¡Hora de regar tu planta!")
        .setPriority(NotificationCompat.PRIORITY_HIGH) // Prioridad alta para mostrarla de inmediato
        .setVibrate(LongArray(0)) // Activa la vibración (en este caso sin patrón)
        .setContentIntent(pendingIntent) // Qué hacer si el usuario toca la notificación
        .setAutoCancel(true) // Se cierra la notificación automáticamente al tocarla
    // Muestra la notificación usando NotificationManagerCompat
    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
}

// Función que crea el PendingIntent que abre la MainActivity al tocar la notificación
fun createPendingIntent(appContext: Context): PendingIntent {
    // Crea el intent que abrirá la actividad principal
    val intent = Intent(appContext, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        // Estas banderas aseguran que se abra una nueva instancia limpia de MainActivity
    }

    // Establece los flags para el PendingIntent
    var flags = PendingIntent.FLAG_UPDATE_CURRENT // Actualiza si ya existe un PendingIntent igual
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        flags = flags or PendingIntent.FLAG_IMMUTABLE // Requerido desde Android 12+
    }

    // Retorna el PendingIntent que abrirá MainActivity al tocar la notificación
    return PendingIntent.getActivity(
        appContext, // Contexto de la app
        REQUEST_CODE, // Código de solicitud (identificador)
        intent, // Intent que se va a ejecutar
        flags // Opciones del PendingIntent
    )
}