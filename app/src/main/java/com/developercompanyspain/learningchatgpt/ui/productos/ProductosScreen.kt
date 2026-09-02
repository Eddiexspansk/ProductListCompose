package com.developercompanyspain.learningchatgpt.ui.productos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ProductosScreen(viewModel: ProductosViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val error = uiState.error
    var categoriaSeleccionada by remember {
        mutableStateOf("todos")
    }
    var menuExpandido by remember {
        mutableStateOf(false)
    }
    val textoCategoria = when (categoriaSeleccionada) {
        "todos" -> "All Categories"
        "electronics" -> "Electronics"
        "jewelery" -> "Jewelery"
        "men's clothing" -> "Men's Clothing"
        "women's clothing" -> "Women's Clothing"
        else -> categoriaSeleccionada
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.cargando) {
                CircularProgressIndicator()
            } else if (error != null) {
                Text(text = error)
            } else {
                Box( modifier = Modifier.align(Alignment.End).padding(end = 16.dp)) {
                    TextButton(
                        onClick = { menuExpandido = true }
                    ) {
                        Text(textoCategoria)

                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Abrir categorías"
                        )
                    }

                    DropdownMenu(
                        expanded = menuExpandido,
                        onDismissRequest = { menuExpandido = false }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "All Categories",
                                    color = if (categoriaSeleccionada == "todos") {
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            },
                            onClick = {
                                categoriaSeleccionada = "todos"
                                menuExpandido = false
                            },
                            modifier = Modifier.background(
                                if (categoriaSeleccionada == "todos") {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surface
                                }
                            )
                        )

                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Electronics",
                                    color = if (categoriaSeleccionada == "electronics") {
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            },
                            onClick = {
                                categoriaSeleccionada = "electronics"
                                menuExpandido = false
                            },
                            modifier = Modifier.background(
                                if (categoriaSeleccionada == "electronics") {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surface
                                }
                            )
                        )

                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Jewelery",
                                    color = if (categoriaSeleccionada == "jewelery") {
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            },
                            onClick = {
                                categoriaSeleccionada = "jewelery"
                                menuExpandido = false
                            },
                            modifier = Modifier.background(
                                if (categoriaSeleccionada == "jewelery") {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surface
                                }
                            )
                        )

                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Men's Clothing",
                                    color = if (categoriaSeleccionada == "men's clothing") {
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            },
                            onClick = {
                                categoriaSeleccionada = "men's clothing"
                                menuExpandido = false
                            },
                            modifier = Modifier.background(
                                if (categoriaSeleccionada == "men's clothing") {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surface
                                }
                            )
                        )

                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Women´s Clothing",
                                    color = if (categoriaSeleccionada == "women's clothing") {
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            },
                            onClick = {
                                categoriaSeleccionada = "women's clothing"
                                menuExpandido = false
                            },
                            modifier = Modifier.background(
                                if (categoriaSeleccionada == "women's clothing") {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surface
                                }
                            )
                        )
                    }
                }
                val productosFiltrados =
                    if (categoriaSeleccionada == "todos") {
                        uiState.productos
                    } else {
                        uiState.productos.filter { producto ->
                            producto.category == categoriaSeleccionada
                        }
                    }

                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(productosFiltrados) { producto ->
                        Card(modifier = Modifier.padding(8.dp)) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = producto.title,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = "${producto.price} €",
                                    style = MaterialTheme.typography.bodyLarge
                                )

                                Text(
                                    text = producto.category,
                                    style = MaterialTheme.typography.bodySmall
                                )

                                Text(
                                    text = producto.description,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                AsyncImage(
                                    model = producto.image,
                                    contentDescription = producto.title,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(180.dp),
                                    contentScale = ContentScale.Fit
                                )

                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { viewModel.cargarProductos() },
                    modifier = Modifier.padding(bottom = 32.dp)
                ) {
                    Text(text = "Load products")
                }
            }
        }
    }
}
