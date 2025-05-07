package com.lixoten.flightsearch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Marca esta clase como una entidad de base de datos Room, con el nombre de tabla "airport"
@Entity(tableName = "airport")
data class Airport(
    // Clave primaria de la tabla. Cada aeropuerto tiene un ID único.
    @PrimaryKey
    val id: Int = 0,
    // Campo "iata_code" en la tabla, representa el código IATA del aeropuerto (por ejemplo: LAX, JFK)
    @ColumnInfo("iata_code")
    val code: String = "",
    // Campo "name" en la tabla, representa el nombre completo del aeropuerto
    @ColumnInfo(name = "name")
    val name: String = "",
    // Campo que representa el número de pasajeros anuales (comentado en @ColumnInfo, pero aún incluido en la clase)
    //@ColumnInfo(name = "passengers")  // ← Esta línea está comentada, por lo que Room no la usará
    val passengers: Int = 0
)

//fun Airport.toAir(): Air = Air(
//    id = id,
//    code = code,
//    name = name,
//)
