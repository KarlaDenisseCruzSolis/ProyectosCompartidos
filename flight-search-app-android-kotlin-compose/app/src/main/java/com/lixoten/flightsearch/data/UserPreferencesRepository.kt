package com.lixoten.flightsearch.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.lixoten.flightsearch.data.UserPreferencesKeys.SEARCH_VALUE
import kotlinx.coroutines.flow.*
import java.io.IOException

// Define la clase de datos que contiene las preferencias del usuario.
data class UserPreferences(
    val searchValue: String = "",// Almacena el valor de búsqueda como una cadena. El valor predeterminado es una cadena vacía.
)

// Define un objeto para las claves de preferencias. En este caso, la clave para "search_value".
object UserPreferencesKeys {
    val SEARCH_VALUE = stringPreferencesKey("search_value")// Define la clave para almacenar y recuperar el valor de búsqueda.
}

// Define una clase que actúa como el repositorio de preferencias del usuario.
class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {

    // Metodo suspendido para actualizar las preferencias del usuario.
    suspend fun updateUserPreferences(
        searchValue: String,// El nuevo valor de búsqueda que se almacenará en las preferencias.
    ) {
        dataStore.edit { preferences ->// Edita las preferencias almacenadas.
            preferences[SEARCH_VALUE] = searchValue// Asigna el nuevo valor de búsqueda a la clave SEARCH_VALUE.
        }
    }

    // Un flujo que emite las preferencias del usuario. Utiliza DataStore para obtener las preferencias.
    val userPreferencesFlow: Flow<UserPreferences> = dataStore.data
        .catch { exception ->// Maneja las excepciones que puedan ocurrir al leer los datos.
            if (exception is IOException) {// Si la excepción es de tipo IOException (problema de entrada/salida), puede ser ignorada o tratada.
                // Handle the exception
            } else {
                throw exception
            }
        }
        .map { preferences ->// Transforma las preferencias almacenadas en un objeto UserPreferences.
            UserPreferences(
                searchValue = preferences[SEARCH_VALUE] ?: "",// Obtiene el valor de la clave SEARCH_VALUE, si no está presente, se asigna una cadena vacía.
            )
        }
}