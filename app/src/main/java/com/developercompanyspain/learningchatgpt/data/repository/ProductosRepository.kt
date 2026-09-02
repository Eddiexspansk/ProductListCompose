package com.developercompanyspain.learningchatgpt.data.repository

import com.developercompanyspain.learningchatgpt.data.model.Producto
import com.developercompanyspain.learningchatgpt.data.remote.RetrofitClient


class ProductosRepository {
    suspend fun obtenerProductos(): List<Producto> {
        return RetrofitClient.api.obtenerProductos()
    }
}
