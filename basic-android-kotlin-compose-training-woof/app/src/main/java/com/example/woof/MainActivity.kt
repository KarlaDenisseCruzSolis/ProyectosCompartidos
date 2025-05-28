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

package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

/**
 * La actividad principal de la aplicación Woof.
 * Extiende ComponentActivity, que es la clase base para actividades que usan Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    /**
     * Llamado cuando la actividad se crea por primera vez.
     * Aquí se configura la interfaz de usuario de la aplicación.
     *
     * @param savedInstanceState Si la actividad está siendo re-inicializada después de haber sido
     * previamente cerrada, este Bundle contiene los datos que suministró más recientemente en
     * [onSaveInstanceState]. De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la interfaz de usuario de la actividad utilizando Jetpack Compose.
        setContent {
            // Aplica el tema definido para la aplicación Woof.
            WoofTheme {
                // Un contenedor de superficie que usa el color 'background' del tema.
                Surface(
                    modifier = Modifier.fillMaxSize() // El modificador fillMaxSize() hace que la superficie ocupe todo el espacio disponible.
                ) {
                    WoofApp() // Llama a la función componible WoofApp, que define el diseño principal de la aplicación.
                }
            }
        }
    }
}

/**
 * Composable que muestra una barra de aplicación y una lista de perros.
 */
@Composable
fun WoofApp() {
    // Scaffold proporciona una estructura de diseño básica para Material Design.
    Scaffold(
        topBar = {
            WoofTopAppBar() // Define la barra superior de la aplicación.
        }
    ) { it ->
        // LazyColumn es un componible que muestra elementos en una lista de desplazamiento vertical.
        // Solo renderiza los elementos visibles, lo que lo hace eficiente para listas grandes.
        LazyColumn(contentPadding = it) { // Aplica el padding del Scaffold al contenido de la lista.
            items(dogs) { // Itera sobre la lista de objetos Dog.
                // Muestra un elemento individual de la lista de perros.
                DogItem(
                    dog = it, // El objeto Dog para este elemento.
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)) // Añade un padding pequeño a cada elemento.
                )
            }
        }
    }
}

/**
 * Composable que muestra un elemento de lista que contiene el icono de un perro y su información.
 *
 * @param dog contiene los datos que rellenan el elemento de la lista.
 * @param modifier modificadores para aplicar a este componible.
 */
@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    // Estado mutable para controlar si la información del perro está expandida o colapsada.
    var expanded by remember { mutableStateOf(false) }
    // Tarjeta de Material Design para agrupar el contenido del elemento del perro.
    Card(
        modifier = modifier
    ) {
        // Columna que contiene el contenido del elemento del perro.
        Column(
            modifier = Modifier
                .animateContentSize( // Anima los cambios de tamaño del contenido.
                    animationSpec = spring( // Especifica una animación de resorte.
                        dampingRatio = Spring.DampingRatioNoBouncy, // Sin efecto de rebote.
                        stiffness = Spring.StiffnessMedium // Rigidez media de la animación.
                    )
                )
        ) {
            // Fila que contiene el icono del perro, la información básica y el botón de expansión.
            Row(
                modifier = Modifier
                    .fillMaxWidth() // La fila ocupa todo el ancho disponible.
                    .padding(dimensionResource(R.dimen.padding_small)) // Añade padding a la fila.
            ) {
                DogIcon(dog.imageResourceId) // Muestra el icono del perro.
                DogInformation(dog.name, dog.age) // Muestra el nombre y la edad del perro.
                Spacer(Modifier.weight(1f)) // Espacio que ocupa el resto del ancho disponible.
                // Botón de expansión/colapso para mostrar/ocultar los hobbies del perro.
                DogItemButton(
                    expanded = expanded, // Pasa el estado actual de expansión.
                    onClick = { expanded = !expanded }, // Cambia el estado de expansión al hacer clic.
                )
            }
            if (expanded) {
                DogHobby(
                    dog.hobbies, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),// Padding inicial.
                        top = dimensionResource(R.dimen.padding_small),// Padding superior.
                        bottom = dimensionResource(R.dimen.padding_medium),// Padding inferior.
                        end = dimensionResource(R.dimen.padding_medium)// Padding final.
                    )
                )
            }
        }
    }
}

/**
 * Composable que muestra un botón que es clicable y muestra un icono de expandir más o expandir menos.
 *
 * @param expanded representa si el icono de expandir más o expandir menos es visible.
 * @param onClick es la acción que ocurre cuando se hace clic en el botón.
 * @param modifier modificadores para aplicar a este componible.
 */
@Composable
private fun DogItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Botón de icono clicable.
    IconButton(
        onClick = onClick, // La acción a ejecutar al hacer clic.
        modifier = modifier
    ) {
        // Icono que cambia entre ExpandLess y ExpandMore dependiendo del estado 'expanded'.
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description), // Descripción de contenido para accesibilidad.
            tint = MaterialTheme.colorScheme.secondary // Color del icono.
        )
    }
}

/**
 * Composable que muestra una barra superior con un icono y texto.
 *
 * @param modifier modificadores para aplicar a este componible.
 */
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    // Barra superior centrada de Material Design 3.
    CenterAlignedTopAppBar(
        title = {
            // Fila que contiene el icono del logo y el texto del título de la aplicación.
            Row(
                verticalAlignment = Alignment.CenterVertically // Alinea verticalmente los elementos al centro.
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))// Establece el tamaño de la imagen.
                        .padding(dimensionResource(R.dimen.padding_small)),// Añade padding a la imagen.
                    painter = painterResource(R.drawable.ic_woof_logo),// Carga la imagen del logo.

                    // La descripción de contenido no es necesaria aquí: la imagen es decorativa, y
                    // establecer una descripción de contenido nula permite que los servicios de accesibilidad
                    // omitan este elemento durante la navegación.

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),// Texto del título de la aplicación.
                    style = MaterialTheme.typography.displayLarge // Aplica un estilo de tipografía grande.
                )
            }
        },
        modifier = modifier
    )
}

/**
 * Composable que muestra una foto de un perro.
 *
 * @param dogIcon es el ID de recurso para la imagen del perro.
 * @param modifier modificadores para aplicar a este componible.
 */
@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))// Establece el tamaño de la imagen.
            .padding(dimensionResource(R.dimen.padding_small))// Añade padding.
            .clip(MaterialTheme.shapes.small),// Recorta la imagen con esquinas redondeadas.
        contentScale = ContentScale.Crop,// Escala la imagen para que recorte el exceso y llene los límites.
        painter = painterResource(dogIcon),// Carga la imagen del perro.

        // La descripción de contenido no es necesaria aquí: la imagen es decorativa, y establecer
        // una descripción de contenido nula permite que los servicios de accesibilidad omitan
        // este elemento durante la navegación.
        contentDescription = null
    )
}

/**
 * Composable que muestra el nombre y la edad de un perro.
 *
 * @param dogName es el ID de recurso para la cadena del nombre del perro.
 * @param dogAge es el Int que representa la edad del perro.
 * @param modifier modificadores para aplicar a este componible.
 */
@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {// Columna que contiene el nombre y la edad del perro.
        Text(
            text = stringResource(dogName), // Muestra el nombre del perro.
            style = MaterialTheme.typography.displayMedium, // Aplica un estilo de tipografía.
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))// Añade padding superior.
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),// Muestra la edad del perro.
            style = MaterialTheme.typography.bodyLarge // Aplica un estilo de tipografía.
        )
    }
}

/**
 * Composable que muestra los hobbies de un perro.
 *
 * @param dogHobby es el ID de recurso para la cadena de texto del hobby a mostrar.
 * @param modifier modificadores para aplicar a este componible.
 */
@Composable
fun DogHobby(
    @StringRes dogHobby: Int,
    modifier: Modifier = Modifier
) {
    Column(// Columna que contiene el título "About" y el texto del hobby.
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.about),// Texto del título "About".
            style = MaterialTheme.typography.labelSmall// Aplica un estilo de tipografía.
        )
        Text(
            text = stringResource(dogHobby),// Muestra el texto del hobby.
            style = MaterialTheme.typography.bodyLarge// Aplica un estilo de tipografía.
        )
    }
}

/**
 * Composable que muestra cómo se ve la UI de la aplicación en tema claro en la pestaña de diseño.
 */
@Preview
@Composable
fun WoofPreview() {
    WoofTheme(darkTheme = false) {// Aplica el tema Woof con el tema oscuro deshabilitado.
        WoofApp()// Muestra la aplicación Woof.
    }
}

/**
 * Composable que muestra cómo se ve la UI de la aplicación en tema oscuro en la pestaña de diseño.
 */
@Preview
@Composable
fun WoofDarkThemePreview() {
    WoofTheme(darkTheme = true) {// Aplica el tema Woof con el tema oscuro habilitado.
        WoofApp()// Muestra la aplicación Woof.
    }
}
