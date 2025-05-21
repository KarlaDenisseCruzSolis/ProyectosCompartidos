/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.superheroes

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

/**
 * Composable que muestra una lista de héroes con animaciones de entrada.
 * @param heroes La lista de objetos Hero a mostrar.
 * @param modifier Un Modifier para este componible.
 * @param contentPadding Relleno a aplicar al contenido de LazyColumn.
 */
@OptIn(ExperimentalAnimationApi::class)// Se requiere esta anotación para usar AnimatedVisibility con MutableTransitionState.
@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    // remember crea y recuerda un estado mutable que se mantiene durante las recomposiciones.
    // MutableTransitionState se usa para controlar el estado de visibilidad para animaciones.
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            // Inicia la animación inmediatamente configurando el estado objetivo en true.
            targetState = true
        }
    }

    // Fade in entry animation for the entire list
    // Animación de aparición para toda la lista.
    AnimatedVisibility(
        visibleState = visibleState,
        // Define la animación de entrada como un fadeIn con un efecto de resorte.
        enter = fadeIn(
            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
        ),
        // Define la animación de salida como un fadeOut.
        exit = fadeOut(),
        modifier = modifier
    ) {
        // LazyColumn es un componible que muestra elementos en una lista de desplazamiento vertical.
        // Solo renderiza los elementos visibles, lo que lo hace eficiente para listas grandes.
        LazyColumn(contentPadding = contentPadding) {
            // itemsIndexed itera sobre la lista de héroes y proporciona el índice de cada elemento.
            itemsIndexed(heroes) { index, hero ->
                // Muestra un elemento individual de la lista de héroes.
                HeroListItem(
                    hero = hero,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)// Añade padding alrededor de cada elemento.
                        // Animate each list item to slide in vertically
                        // Anima la entrada y salida de cada elemento de la lista para deslizarse verticalmente.
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = StiffnessVeryLow,// Baja rigidez para un movimiento más suave.
                                    dampingRatio = DampingRatioLowBouncy// Baja relación de amortiguación para un rebote suave.
                                ),
                                initialOffsetY = { it * (index + 1) } // Entrada escalonada: cada elemento comienza un poco más abajo.
                            )
                        )
                )
            }
        }
    }
}

/**
 * Composable que muestra un solo elemento de héroe en una tarjeta.
 * @param hero El objeto Hero a mostrar.
 * @param modifier Un Modifier para este componible.
 */
@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(// Card es un componente de Material Design que se utiliza para agrupar contenido y acciones relacionadas.
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // Establece la elevación de la tarjeta para una sombra.
        modifier = modifier,
    ) {
        Row(// Fila que contiene el nombre del héroe, la descripción y la imagen.
            modifier = Modifier
                .fillMaxWidth()// La fila ocupa todo el ancho disponible.
                .padding(16.dp)// Añade padding interno a la fila.
                .sizeIn(minHeight = 72.dp)// Establece una altura mínima para la fila.
        ) {
            // Columna para el texto (nombre y descripción del héroe).
            Column(modifier = Modifier.weight(1f)) {// La columna ocupa el peso restante de la fila.
                Text(
                    text = stringResource(hero.nameRes),// Muestra el nombre del héroe desde los recursos de cadena.
                    style = MaterialTheme.typography.displaySmall// Aplica el estilo de tipografía displaySmall.
                )
                Text(
                    text = stringResource(hero.descriptionRes),// Muestra la descripción del héroe desde los recursos de cadena.
                    style = MaterialTheme.typography.bodyLarge// Aplica el estilo de tipografía bodyLarge.
                )
            }
            Spacer(Modifier.width(16.dp))// Espacio horizontal entre el texto y la imagen.
            Box(// Caja para la imagen del héroe.
                modifier = Modifier
                    .size(72.dp)// Establece el tamaño de la caja.
                    .clip(RoundedCornerShape(8.dp))// Recorta la caja con esquinas redondeadas.

            ) {
                Image(// Muestra la imagen del héroe.
                    painter = painterResource(hero.imageRes),// Carga la imagen desde los recursos.
                    contentDescription = null,// No se proporciona descripción de contenido ya que es decorativa.
                    alignment = Alignment.TopCenter,// Alinea la imagen en la parte superior central.
                    contentScale = ContentScale.FillWidth// Escala la imagen para que llene el ancho.
                )
            }
        }
    }
}

/**
 * Vista previa para un solo elemento de héroe en tema claro y oscuro.
 */
@Preview("Light Theme") // Anotación para una vista previa con el tema claro.
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES) // Anotación para una vista previa con el tema oscuro.
@Composable
fun HeroPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme { // Aplica el tema Superheroes a la vista previa.
        HeroListItem(hero = hero)// Muestra el componente HeroListItem con el héroe de ejemplo.
    }
}

/**
 * Vista previa para la lista completa de héroes.
 */
@Preview("Heroes List") // Anotación para una vista previa de la lista de héroes.
@Composable
fun HeroesPreview() {
    // Aplica el tema Superheroes con el tema oscuro deshabilitado.
    SuperheroesTheme(darkTheme = false) {
        Surface (
            color = MaterialTheme.colorScheme.background // Establece el color de fondo de la superficie.
        ) {
            /* Importante: No es una buena práctica acceder a la fuente de datos directamente desde la interfaz de usuario.
            En unidades posteriores aprenderás a usar ViewModel en escenarios donde toma la
            fuente de datos como dependencia y expone a los héroes.
            */
            // Muestra el componente HeroesList con los héroes del repositorio.
            HeroesList(heroes = HeroesRepository.heroes)
        }
    }
}
