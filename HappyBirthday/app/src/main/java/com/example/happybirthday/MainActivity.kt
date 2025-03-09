package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image // Nuevo import
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource // Nuevo import
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background // Fondo de la interfaz
                ) {
                    GreetingText(
                        message = "Happy Birthday Karla!",
                        from = "From Martin",
                        modifier = Modifier.padding(8.dp)// Añadir padding alrededor del contenido
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) { // Se usa Box para superponer la imagen y el texto
        Image( // Se agrega la imagen de fondo
            painter = painterResource(R.drawable.androidparty), // Se carga la imagen
            contentDescription = null,// No es necesario describir la imagen aquí
            contentScale = ContentScale.Crop, //Ajuste de escala
            alpha = 0.6f, // Opacidad al 50%

            modifier = Modifier.fillMaxSize()// La imagen ocupa todo el espacio disponible
        )

        Column(
            verticalArrangement = Arrangement.Center,// Centra el texto verticalmente
            modifier = Modifier.fillMaxSize() // La columna ocupa todo el espacio disponible
        ) {
            Text(
                text = message,// Muestra el mensaje de cumpleaños
                fontSize = 100.sp,// Tamaño grande para el mensaje
                lineHeight = 116.sp,// Altura de línea para mayor espacio entre las líneas
                textAlign = TextAlign.Center // Centra el texto
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End)// Alinea el texto al final (derecha)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {// Aplica el tema a la vista previa
        GreetingText(
            message = "Happy Birthday Karla!",
            from = "From Martin"
        )
    }
}