package com.example.clima

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.clima.ui.theme.ClimaTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimaTheme {
                MainScreen()
            }
        }
    }
}

// Data classes for API response
data class WeatherResponse(
    val weather: List<Weather>,
    val main: Main,
    val name: String,
    val dt: Long
)

data class Weather(
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double
)

// Retrofit interface
interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String,
        @Query("lang") lang: String = "es"
    ): WeatherResponse
}

// Function to get Retrofit instance
fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

@Composable
fun MainScreen() {
    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var isCelsius by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val city = "Mexico" // Change to your desired city
    val apiKey = "b1816d22e2556b9bec86c3bb73603693" // Replace with your API key

    LaunchedEffect(city, isCelsius) {
        isLoading = true
        errorMessage = null
        try {
            val units = if (isCelsius) "metric" else "imperial"
            val response = withContext(Dispatchers.IO) {
                getRetrofit().create(WeatherApi::class.java).getCurrentWeather(city, apiKey, units)
            }
            weatherData = response
        } catch (e: HttpException) {
            // Error de HTTP (4xx o 5xx)
            Log.e("MainActivity", "Error HTTP: ${e.code()}", e)
            errorMessage = "Error al obtener los datos del clima (Error HTTP: ${e.code()})"
        } catch (e: IOException) {
            // Error de red
            Log.e("MainActivity", "Error de red", e)
            errorMessage = "Error de red al obtener los datos del clima"
        } catch (e: Exception) {
            // Otro tipo de error
            Log.e("MainActivity", "Error desconocido", e)
            errorMessage = "Error desconocido al obtener los datos del clima"
        } finally {
            isLoading = false
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else if (errorMessage != null) {
                Text(text = errorMessage!!, color = MaterialTheme.colorScheme.error)
            } else if (weatherData != null) {
                val weather = weatherData!!.weather[0]
                val main = weatherData!!.main
                val temperature = if (isCelsius) main.temp.toInt() else main.temp.toInt()
                val feelsLike = if (isCelsius) main.feels_like.toInt() else main.feels_like.toInt()
                val minTemp = if (isCelsius) main.temp_min.toInt() else main.temp_min.toInt()
                val maxTemp = if (isCelsius) main.temp_max.toInt() else main.temp_max.toInt()
                val formattedDate = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(weatherData!!.dt * 1000))

                Text(text = weatherData!!.name, style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = formattedDate, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = rememberAsyncImagePainter(
                        model = "https://openweathermap.org/img/wn/${weather.icon}@2x.png"
                    ),
                    contentDescription = weather.description,
                    modifier = Modifier.size(128.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "$temperature°${if (isCelsius) "C" else "F"}", style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Sensación térmica: $feelsLike°${if (isCelsius) "C" else "F"}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Mínima: $minTemp°${if (isCelsius) "C" else "F"} / Máxima: $maxTemp°${if (isCelsius) "C" else "F"}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Celsius")
                    Switch(
                        checked = isCelsius,
                        onCheckedChange = { isCelsius = it }
                    )
                    Text("Fahrenheit")
                }
            }
        }
    }
}