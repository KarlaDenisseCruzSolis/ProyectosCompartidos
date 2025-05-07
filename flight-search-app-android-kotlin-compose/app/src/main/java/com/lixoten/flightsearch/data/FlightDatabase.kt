package com.lixoten.flightsearch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lixoten.flightsearch.model.Airport
import com.lixoten.flightsearch.model.Favorite

// Anotación que define la clase como una base de datos de Room. Se especifican las entidades (tablas) y la versión de la base de datos.
@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class FlightDatabase: RoomDatabase() {

    abstract fun flightDao(): FlightDao// Definición de un metodo abstracto para acceder al DAO (Data Access Object) que contiene las consultas para la base de datos

    companion object {// Companion object, que garantiza que solo haya una instancia de la base de datos (singleton)
        @Volatile
        private var Instance: FlightDatabase? = null

        fun getDatabase(context: Context): FlightDatabase {// Metodo que devuelve la instancia única de la base de datos, o la crea si no existe
            // Si la instancia ya existe, simplemente la retorna. Si no, crea una nueva instancia de la base de datos.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(// Construcción de la base de datos utilizando Room
                    context,// Contexto de la aplicación
                    FlightDatabase::class.java,// Clase de la base de datos
                    "flight_database"// Nombre del archivo de la base de datos
                )
                    // Indica que la base de datos se debe crear a partir de un archivo de base de datos preexistente en assets
                    .createFromAsset("database/flight_search.db")
                    /**
                     * Si no se encuentra un camino de migración definido para la base de datos, esta opción elimina los datos existentes
                     * para realizar una migración destructiva, es decir, borra la base de datos si no tiene una migración adecuada.
                     */
                    .fallbackToDestructiveMigration()
                    .build()// Construcción de la base de datos
                    .also { Instance = it }// Asigna la instancia recién creada
            }
        }
    }
}