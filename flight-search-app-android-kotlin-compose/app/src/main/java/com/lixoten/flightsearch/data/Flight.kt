package com.lixoten.flightsearch.data

// Declaración de una clase de datos (data class) llamada Flight
data class Flight(
    val id: Int = 0, // Identificador único del vuelo (no se usa en la base de datos, es solo informativo en este modelo)
    val departureCode: String ="", // Código IATA del aeropuerto de salida (por ejemplo: "JFK", "LAX")
    val departureName: String="",  // Nombre del aeropuerto de salida (por ejemplo: "John F. Kennedy International Airport")
    val destinationCode: String="", // Código IATA del aeropuerto de destino
    val destinationName: String="",// Nombre del aeropuerto de destino
    val isFavorite: Boolean=false// Indica si el vuelo es favorito o no; por defecto es false
)
