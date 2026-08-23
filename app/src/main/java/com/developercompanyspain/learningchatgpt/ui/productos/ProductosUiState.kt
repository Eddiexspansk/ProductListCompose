package com.developercompanyspain.learningchatgpt.ui.productos

import com.developercompanyspain.learningchatgpt.data.model.Producto

data class ProductosUiState(
    val cargando: Boolean = false,
    val productos: List<Producto> = emptyList(),
    val error: String? = null,
)
