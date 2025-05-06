package com.lixoten.flightsearch


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lixoten.flightsearch.ui.screens.flight_screen.FlightScreen
import com.lixoten.flightsearch.ui.screens.flight_screen.FlightScreenDestination
//import com.lixoten.flightsearch.ui.screens.flight_screen.FlightScreen
//import com.lixoten.flightsearch.ui.screens.flight_screen.FlightScreenDestination
import com.lixoten.flightsearch.ui.screens.search.SearchDestination
import com.lixoten.flightsearch.ui.screens.search.SearchScreen


@Composable
fun FlightSearchApp() { // Función principal de la interfaz, define la estructura de navegación de la app.
    val navController = rememberNavController() // Crea y recuerda un controlador de navegación para gestionar las rutas.
    Scaffold() { paddingValues -> // Usa un Scaffold para manejar estructura base de la UI. paddingValues se usa para adaptar márgenes.
        NavHost( // Contenedor de navegación que define las rutas y sus composables correspondientes.
            navController = navController, // Usa el controlador de navegación creado anteriormente.
            startDestination = SearchDestination.route, // Define la pantalla de inicio como la de búsqueda.
            modifier = Modifier.padding(paddingValues) // Aplica el padding generado por el Scaffold.
        ) {
            composable(route = SearchDestination.route) { // Define una ruta composable para la pantalla de búsqueda.
                SearchScreen( // Muestra la pantalla de búsqueda.
                    modifier = Modifier, // No se aplica modificación adicional.
                    onSelectCode = { // Callback que se ejecuta cuando el usuario selecciona un código.
                        navController.navigate("${FlightScreenDestination.route}/${it}") // Navega a la pantalla de vuelos pasando el código seleccionado.
                    }
                )
            }
            composable( // Define otra ruta composable para mostrar la pantalla de vuelos.
                route = FlightScreenDestination.routeWithArgs, // Usa la ruta con argumento definido en FlightScreenDestination.
                arguments = listOf(navArgument(FlightScreenDestination.codeArg) { // Define que esta ruta requiere un argumento de tipo String.
                    type = NavType.StringType
                }
                )
            ) { navBackStackEntry -> // Bloque que se ejecuta cuando se navega a esta ruta.
                // Retrieve the passed argument
                //val code =
                //    navBackStackEntry.arguments?.getString(FlightScreenDestination.codeArg) // Comentado: se iba a usar para obtener el argumento.
                FlightScreen() // Muestra la pantalla de vuelos.
            }
        }
    }
}