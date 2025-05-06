package com.lixoten.flightsearch

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.lixoten.flightsearch.data.UserPreferencesRepository
import com.lixoten.flightsearch.di.AppContainer
import com.lixoten.flightsearch.di.AppDataContainer


private const val LAYOUT_PREFERENCE_NAME = "layout_preferences" // Define el nombre del archivo de preferencias.
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore( // Crea una extensión de Context que inicializa un DataStore con el nombre definido.
    name = LAYOUT_PREFERENCE_NAME
)

class FlightApplication : Application() { // Clase que extiende Application, se ejecuta al inicio de la app.

    /**
     * Instancia de AppContainer usada por el resto de las clases para obtener dependencias
     */
    lateinit var container: AppContainer // Contenedor de dependencias, accesible en toda la app.

    lateinit var userPreferencesRepository: UserPreferencesRepository // Repositorio para manejar las preferencias del usuario.

    override fun onCreate() { // Metodo llamado al inicio de la aplicación.
        super.onCreate()
        container = AppDataContainer(this) // Se inicializa el contenedor con el contexto de la app.
        userPreferencesRepository = UserPreferencesRepository(dataStore) // Se crea la instancia del repositorio usando el DataStore definido.
    }
}

//class BusScheduleApplication: Application() {
//    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
//}
