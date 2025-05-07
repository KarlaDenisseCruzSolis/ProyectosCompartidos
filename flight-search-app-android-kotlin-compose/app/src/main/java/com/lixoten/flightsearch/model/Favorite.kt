package com.lixoten.flightsearch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lixoten.flightsearch.data.Flight

// Esta anotación convierte a la clase en una entidad de base de datos Room, con tabla llamada "favorite"
@Entity(tableName = "favorite")
data class Favorite(
    // Clave primaria autogenerada. Room incrementará automáticamente este ID.
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    // Campo en la base de datos llamado "departure_code", almacena el código del aeropuerto de origen
    @ColumnInfo("departure_code")
    val departureCode: String,
    // Campo en la base de datos llamado "destination_code", almacena el código del aeropuerto de destino
    @ColumnInfo(name = "destination_code")
    val destinationCode: String,
)
//{
//    fun toFlight(departureName: String, destinationName: String): Flight {
//        return Flight(
//            id = id,
//            departureCode = departureCode,
//            departureName = departureName,
//            destinationCode = destinationCode,
//            destinationName = destinationName,
//            isFavorite = false
//        )
//    }
//}

