package com.developercompanyspain.learningchatgpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.developercompanyspain.learningchatgpt.ui.productos.ProductosScreen
import com.developercompanyspain.learningchatgpt.ui.productos.ProductosViewModel
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: ProductosViewModel = viewModel()
            ProductosScreen(viewModel)
        }
    }
}
