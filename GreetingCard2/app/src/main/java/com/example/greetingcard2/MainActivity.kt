package com.example.greetingcard2
// Este es un comentario de prueba para Git 1 en visual studio code
//Este es un cambio para probar conexión karla a yahir
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)// Llama al constructor de la superclase
        setContent {
            GreetingCard2Theme {
                // A surface container that uses the 'background' color from the theme
                // Crea un contenedor con un fondo basado en el tema
                Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    Greeting("Karla Cruz")
                }
            }
        }
    }
}
// Función que muestra un saludo en pantalla
@Composable
fun Greeting(name: String) {
    Surface(color = Color.Magenta) {// Contenedor con fondo de color magenta
        Text(text = "Hi, we are $name!", modifier = Modifier.padding(24.dp))// Muestra el texto con el nombre recibido y Agrega un margen de 24dp alrededor del texto
    }
}
// Función que muestra una vista previa en el editor de Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingCard2Theme {
        Greeting("Karla y Yahir")// Llama a la función Greeting con un nombre de prueba
    }
    
}