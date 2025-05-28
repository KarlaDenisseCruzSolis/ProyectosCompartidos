/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Paquete principal de la app
package com.example.woof

// Importaciones necesarias para componer la UI, gestionar estados, temas, recursos y elementos visuales
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.Dog
import com.example.woof.data.dogs
import com.example.woof.ui.theme.WoofTheme

// Actividad principal de la app
class MainActivity : ComponentActivity() {
    // Método que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase padre
        setContent { // Establece el contenido visual de la app
            WoofTheme { // Aplica el tema personalizado Woof
                Surface( // Crea una superficie base que usa el color de fondo del tema
                    modifier = Modifier.fillMaxSize() // Hace que ocupe todo el tamaño de la pantalla
                ) {
                    WoofApp() // Llama al composable principal de la app
                }
            }
        }
    }
}

// Composable que muestra el top app bar y la lista de perros
@Composable
fun WoofApp() {
    Scaffold( // Composable que proporciona estructura de diseño con top bar y contenido
        topBar = {
            WoofTopAppBar() // Composable que dibuja la barra superior de la app
        }
    ) { it -> // it es el padding proporcionado por el Scaffold
        LazyColumn(contentPadding = it) { // Lista perezosa que muestra los elementos
            items(dogs) { // Recorre cada perro de la lista dogs
                DogItem(
                    dog = it, // Pasa el objeto Dog actual
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)) // Aplica padding
                )
            }
        }
    }
}

// Composable que representa una tarjeta individual para cada perro
@Composable
fun DogItem(
    dog: Dog, // Objeto Dog a mostrar
    modifier: Modifier = Modifier // Modificadores opcionales
) {
    var expanded by remember { mutableStateOf(false) } // Estado para saber si está expandido o no

    Card( // Contenedor visual tipo tarjeta
        modifier = modifier // Aplica los modificadores recibidos
    ) {
        Column(
            modifier = Modifier
                .animateContentSize( // Anima el cambio de tamaño del contenido
                    animationSpec = spring( // Define la animación tipo resorte
                        dampingRatio = Spring.DampingRatioNoBouncy, // Sin rebote
                        stiffness = Spring.StiffnessMedium // Rigidez media
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho disponible
                    .padding(dimensionResource(R.dimen.padding_small)) // Aplica padding
            ) {
                DogIcon(dog.imageResourceId) // Muestra la imagen del perro
                DogInformation(dog.name, dog.age) // Muestra el nombre y edad
                Spacer(Modifier.weight(1f)) // Empuja el botón al final del row
                DogItemButton( // Botón para expandir/colapsar
                    expanded = expanded,
                    onClick = { expanded = !expanded }, // Cambia el estado al hacer clic
                )
            }
            if (expanded) { // Si está expandido, muestra los hobbies
                DogHobby(
                    dog.hobbies,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

// Composable que muestra un botón de expandir/colapsar
@Composable
private fun DogItemButton(
    expanded: Boolean, // Estado actual del botón
    onClick: () -> Unit, // Acción al hacer clic
    modifier: Modifier = Modifier // Modificadores opcionales
) {
    IconButton( // Botón con ícono
        onClick = onClick, // Ejecuta la función al hacer clic
        modifier = modifier // Aplica modificadores
    ) {
        Icon( // Muestra el ícono expandir más o menos
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description), // Descripción accesible
            tint = MaterialTheme.colorScheme.secondary // Color del ícono
        )
    }
}

// Composable que muestra la barra superior de la app
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar( // Barra superior centrada
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically // Centra verticalmente los elementos del row
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size)) // Tamaño de la imagen
                        .padding(dimensionResource(R.dimen.padding_small)), // Padding
                    painter = painterResource(R.drawable.ic_woof_logo), // Imagen del logo
                    contentDescription = null // No se necesita descripción (imagen decorativa)
                )
                Text(
                    text = stringResource(R.string.app_name), // Nombre de la app
                    style = MaterialTheme.typography.displayLarge // Estilo del texto
                )
            }
        },
        modifier = modifier // Aplica modificadores
    )
}

// Composable que muestra la imagen del perro
@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int, // Recurso drawable del perro
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size)) // Tamaño de la imagen
            .padding(dimensionResource(R.dimen.padding_small)) // Padding
            .clip(MaterialTheme.shapes.small), // Recorta la imagen con esquinas redondeadas
        contentScale = ContentScale.Crop, // Ajuste de imagen para llenar el contenedor
        painter = painterResource(dogIcon), // Imagen del recurso
        contentDescription = null // Imagen decorativa sin descripción
    )
}

// Composable que muestra el nombre y edad del perro
@Composable
fun DogInformation(
    @StringRes dogName: Int, // Recurso de string del nombre
    dogAge: Int, // Edad del perro
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName), // Texto del nombre
            style = MaterialTheme.typography.displayMedium, // Estilo de texto
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)) // Padding superior
        )
        Text(
            text = stringResource(R.string.years_old, dogAge), // Texto con edad
            style = MaterialTheme.typography.bodyLarge // Estilo de texto
        )
    }
}

// Composable que muestra los hobbies del perro
@Composable
fun DogHobby(
    @StringRes dogHobby: Int, // Recurso de string con el hobby
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier // Aplica modificadores
    ) {
        Text(
            text = stringResource(R.string.about), // Texto "Acerca de"
            style = MaterialTheme.typography.labelSmall // Estilo de etiqueta
        )
        Text(
            text = stringResource(dogHobby), // Texto con el hobby
            style = MaterialTheme.typography.bodyLarge // Estilo principal
        )
    }
}

// Vista previa del diseño en modo claro
@Preview
@Composable
fun WoofPreview() {
    WoofTheme(darkTheme = false) { // Aplica tema claro
        WoofApp() // Muestra la app
    }
}

// Vista previa del diseño en modo oscuro
@Preview
@Composable
fun WoofDarkThemePreview() {
    WoofTheme(darkTheme = true) { // Aplica tema oscuro
        WoofApp() // Muestra la app
    }
}