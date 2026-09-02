package com.developercompanyspain.learningchatgpt.data.remote

import com.developercompanyspain.learningchatgpt.data.model.Producto
import retrofit2.http.GET

interface FakeStoreApi {
        @GET("products")
        suspend fun obtenerProductos(): List<Producto>
    }
