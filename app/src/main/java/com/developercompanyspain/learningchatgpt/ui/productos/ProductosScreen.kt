package com.developercompanyspain.learningchatgpt.ui.productos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductosScreen(viewModel: ProductosViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val error = uiState.error

    LaunchedEffect(Unit) {
        viewModel.cargarProductos()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (uiState.cargando) {
                CircularProgressIndicator()
            } else if (error != null) {
                Text(text = error)
            } else {
                Column {
                    uiState.productos.forEach { producto ->
                        Text(text = producto.nombre)
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = { viewModel.cargarProductos() }) {
                    Text(text = "Load products")
                }
            }
        }
    }
}
