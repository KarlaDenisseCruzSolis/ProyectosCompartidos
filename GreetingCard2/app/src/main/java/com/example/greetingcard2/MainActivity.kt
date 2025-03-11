package com.example.greetingcard2 // Declaración del paquete que contiene la aplicación.

import android.os.Bundle // Importa la clase Bundle, utilizada para pasar información entre actividades.
import androidx.activity.ComponentActivity // Importa la clase base para actividades en Android que usan Jetpack Compose.
import androidx.activity.compose.setContent // Permite establecer el contenido de la actividad usando Compose.
import androidx.compose.foundation.layout.fillMaxSize // Permite que los elementos de la UI ocupen todo el espacio disponible.
import androidx.compose.foundation.layout.padding // Permite agregar márgenes a los elementos de la UI.
import androidx.compose.material3.MaterialTheme // Importa el tema visual predeterminado de Material 3.
import androidx.compose.material3.Surface // Permite crear una superficie donde se coloca el contenido.
import androidx.compose.material3.Text // Permite crear un componente de texto.
import androidx.compose.runtime.Composable // Anotación para indicar que una función es un componente de la UI en Compose.
import androidx.compose.ui.Modifier // Permite modificar el comportamiento o apariencia de los componentes de la UI.
import androidx.compose.ui.graphics.Color // Permite trabajar con colores en Compose.
import androidx.compose.ui.tooling.preview.Preview // Permite ver una vista previa de los componentes en Android Studio.
import androidx.compose.ui.unit.dp // Permite especificar unidades de medida en densidad independiente (dp).
import com.example.greetingcard2.ui.theme.GreetingCard2Theme // Importa el tema personalizado de la aplicación.

class MainActivity : ComponentActivity() { // La actividad principal de la aplicación, que extiende ComponentActivity.
    override fun onCreate(savedInstanceState: Bundle?) { // Método que se llama cuando la actividad es creada.
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase base.
        setContent { // Establece el contenido de la actividad usando Jetpack Compose.
            GreetingCard2Theme { // Utiliza el tema personalizado de la aplicación.
                Surface( // Crea una superficie para el contenido.
                    modifier = Modifier.fillMaxSize(), // Hace que la superficie ocupe todo el espacio disponible.
                    color = MaterialTheme.colorScheme.background // Define el color de fondo usando el esquema de colores del tema.
                ) {
                    Greeting("Karla Cruz") // Llama a la función Greeting, pasando el nombre "Karla Cruz".
                }
            }
        }
    }
}

@Composable // Indica que esta función es un componente de la UI en Compose.
fun Greeting(name: String) { // Función que recibe un nombre y muestra un saludo.
    Surface(color = Color.Green) { // Crea una superficie con un color de fondo cian.
        Text(text = "Hi, $name! Modificando Karla.", modifier = Modifier.padding(24.dp)) // Muestra un texto con el nombre y un mensaje. Añade un padding de 24dp.
    }
}

@Preview(showBackground = true) // Permite ver una vista previa de la UI en Android Studio.
@Composable // Anotación para indicar que la función es un componente de la UI en Compose.
fun DefaultPreview() { // Función para la vista previa de la UI.
    GreetingCard2Theme { // Aplica el tema personalizado a la UI de la vista previa.
        Greeting("we are Karla y Yahir") // Muestra un saludo con los nombres "Karla y Yahir" en la vista previa.
    }
}