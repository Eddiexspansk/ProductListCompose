package com.developercompanyspain.learningchatgpt.data.repository

import com.developercompanyspain.learningchatgpt.data.model.Producto
import kotlinx.coroutines.delay

class ProductosRepository {
    suspend fun obtenerProductos(): List<Producto> {
        delay(2000)
        return listOf(
            Producto(1, "Laptop"),
            Producto(2, "Keyboard"),
        )
    }
}
