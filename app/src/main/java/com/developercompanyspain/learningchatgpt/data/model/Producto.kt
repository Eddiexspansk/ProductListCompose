package com.developercompanyspain.learningchatgpt.data.model

data class Producto(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String
)
