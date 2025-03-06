package com.example.greetingcard2
// Actualización 1. Este es un comentario de prueba para Git 1 en visual studio code
// Actualización 2. Este es un cambio para probar conexión karla a yahir
// Actualización 3. Ejecuta el programa
// Actualización 4. Mensaje de Karla a Yahir
// Actualización 5. Implementación de comentarios

// Importaciones necesarias para el funcionamiento de la aplicación
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface // Contenedor de fondo con color y estilo
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard2.ui.theme.GreetingCard2Theme

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al constructor de la superclase
        setContent {
            // Aplica el tema definido en GreetingCard2Theme
            GreetingCard2Theme {
                // Contenedor Surface que ocupa toda la pantalla y usa el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama a la función Greeting y pasa un nombre como parámetro
                    Greeting("Karla Cruz")
                }
            }
        }
    }
}

// Función que muestra un saludo en pantalla
@Composable
fun Greeting(name: String) {
    Surface(color = Color.Magenta) { // Contenedor con fondo de color magenta
        Text(
            text = "Hi, $name! Ya modifiqué (Soy Yahir).", // Mensaje de saludo personalizado
            modifier = Modifier.padding(24.dp) // Aplica un margen de 24dp alrededor del texto
        )
    }
}

// Función que genera una vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingCard2Theme {
        Greeting("Karla") // Muestra un saludo con un nombre de prueba en la vista previa
    }
}
