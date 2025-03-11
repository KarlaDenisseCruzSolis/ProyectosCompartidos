package com.example.happybirthday // Define el paquete de la aplicación

import android.os.Bundle // Importaciones necesarias para la actividad y el diseño en Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.happybirthday.ui.theme.HappyBirthdayTheme // Importa el tema de la aplicación
import androidx.compose.foundation.layout.* // Importaciones para la disposición y el diseño de la interfaz
import androidx.compose.material3.* // Importa Material 3 para los componentes visuales
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image // Importaciones adicionales para manejar imágenes
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign // Importaciones para el formato del texto
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Define medidas en dp (density-independent pixels)
import androidx.compose.ui.unit.sp // Define tamaños de fuente en sp (scale-independent pixels)


class MainActivity : ComponentActivity() { // Clase principal de la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // Establece el contenido de la interfaz con Jetpack Compose
            HappyBirthdayTheme { // Aplica el tema de la aplicación
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
                ) {
                    GreetingText( // Llama a la función GreetingText con el mensaje de felicitación
                        message = "Happy Birthday Karla!", // Mensaje de cumpleaños
                        from = "From Martin", // Nombre del remitente
                        modifier = Modifier.padding(8.dp) // Agrega un margen alrededor del contenido
                    )
                }
            }
        }
    }
}

@Composable // Función que muestra el mensaje de cumpleaños y la imagen de fondo
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) { // Box permite superponer elementos
        Image( // Agrega la imagen de fondo
            painter = painterResource(R.drawable.androidparty), // Carga la imagen desde los recursos
            contentDescription = null, // No se necesita descripción accesible
            contentScale = ContentScale.Crop, // Ajusta la imagen para llenar el espacio sin distorsionarse
            alpha = 0.6f, // Ajusta la opacidad de la imagen al 60%

            modifier = Modifier.fillMaxSize() // La imagen ocupa toda la pantalla
        )

        Column( // Columna para organizar el texto verticalmente
            verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente
            modifier = Modifier.fillMaxSize() // La columna ocupa toda la pantalla
        ) {
            Text( // Texto principal con el mensaje de cumpleaños
                text = message, // Usa el mensaje recibido como parámetro
                fontSize = 100.sp, // Tamaño grande para mayor impacto
                lineHeight = 116.sp, // Espaciado entre líneas
                textAlign = TextAlign.Center // Centra el texto horizontalmente
            )
            Text( // Texto con el remitente del mensaje
                text = from, // Usa el nombre recibido como parámetro
                fontSize = 36.sp, // Tamaño de fuente más pequeño
                modifier = Modifier
                    .padding(16.dp) // Agrega margen alrededor del texto
                    .align(alignment = Alignment.End)// Alinea el texto al final (derecha)
            )
        }
    }
}

@Preview(showBackground = true) // Función para previsualizar la tarjeta de cumpleaños en el editor de Android Studio
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {// Aplica el tema a la vista previa
        GreetingText(
            message = "Happy Birthday Karla!", // Mensaje de ejemplo
            from = "From Martin" // Nombre de quien envía la felicitación
        )
    }
}