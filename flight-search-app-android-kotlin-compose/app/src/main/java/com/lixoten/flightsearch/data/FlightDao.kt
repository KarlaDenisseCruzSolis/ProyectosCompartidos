package com.lixoten.flightsearch.data

import androidx.room.*
import com.lixoten.flightsearch.model.Airport
import com.lixoten.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {// Anotación que indica que esta interfaz es un DAO de Room
    @Query(// Consulta que devuelve todos los registros de la tabla "favorite", ordenados por ID ascendente
        """
        Select * from favorite
        ORDER BY id ASC
        """
    )
    //fun getAllAirports(): Flow<List<Airport>>
    suspend fun getAllFavorites(): List<Favorite>// Metodo suspendido que devuelve la lista de favoritos (modo sincrónico para uso en corrutinas)
    @Query(// Misma consulta anterior, pero expuesta como un Flow para obtener actualizaciones en tiempo real
        """
        Select * from favorite
        ORDER BY id ASC
        """
    )
    fun getAllFavoritesFlow(): Flow<List<Favorite>>

    @Query(// Consulta que busca un único favorito que coincida con un código de salida y uno de destino
        """
        SELECT * FROM favorite
        WHERE departure_code = :departureCode
          AND destination_code = :destinationCode
        """
    )
    suspend fun getSingleFavorite(departureCode: String, destinationCode: String): Favorite



    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    // Inserta un vuelo favorito en la base de datos
    // Reemplaza el existente si ya hay un registro con el mismo ID (REPLACE)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteFlight(flight: Favorite)
    @Delete // Elimina un vuelo favorito de la base de datos
    suspend fun deleteFavoriteFlight(flight: Favorite)



//    Select * from airport
//    WHERE name LIKE :name
//    ORDER BY name ASC
    @Query(// Consulta que obtiene todos los aeropuertos como un Flow (actualización en tiempo real)
        """
        Select * from airport 
        ORDER BY id ASC 
        """
    )
    fun getAllAirportsFlow(): Flow<List<Airport>>
    @Query(// Consulta que obtiene todos los aeropuertos como lista suspendida
        """
        Select * from airport 
        ORDER BY id ASC 
        """
    )
    //fun getAllAirports(): Flow<List<Airport>>
    suspend fun getAllAirports(): List<Airport>



    @Query(// Consulta que filtra aeropuertos por código IATA o por coincidencia parcial en el nombre
           // Devuelve un Flow con los resultados en tiempo real
        """
    Select * from airport
    WHERE iata_code = :query OR name LIKE '%' || :query || '%'        
    ORDER BY name ASC
        """
    )
    fun getAllAirportsFlow(query: String): Flow<List<Airport>>



    //"SELECT * from airport WHERE iata_code= :query OR name LIKE '%' || :query || '%' ")

    //WHERE name LIKE 'Fr%'
    @Query(
        """
    Select * from airport
    WHERE iata_code = :query OR name LIKE '%' || :query || '%'        
    ORDER BY name ASC
        """
    )
    //fun getAllAirports(query: String): Flow<List<Airport>>
    suspend fun getAllAirports(query: String): List<Airport>

    @Query(
        """
    Select * from airport
    WHERE iata_code = :code
        """
    )
    //fun getAirportByCode(code: String): Flow<Airport>
    suspend fun getAirportByCode(code: String): Airport
    @Query(
        """
    Select * from airport
    WHERE iata_code = :code
        """
    )
    fun getAirportByCodeFlow(code: String): Flow<Airport>





    @Query(
        """
    Select * from airport
    WHERE id = :id
        """
    )
    //fun getAirportById(id: Int): Flow<Airport>
    suspend fun getAirportById(id: Int): Airport


    //
    //@Query("SELECT * FROM airport ORDER BY passengers DESC")
    //suspend fun getAirports(): List<Airport>
    //

//    @Query(
//        """
//    Select * from airport
//    WHERE iata_code = :ito
//    ORDER BY name ASC
//        """
//    )
//    fun getAllFlights(ito: String): Flow<List<Airport>>



    //@Query("SELECT * FROM favorite")
    //fun getFavoriteFlightsStream(): Flow<List<FavoriteFlight>>

    //@Query("SELECT * FROM favorite WHERE id = :id")
    //suspend fun getFavoriteFlight(id: Int): FavoriteFlight?



}