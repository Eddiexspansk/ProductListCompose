package com.developercompanyspain.learningchatgpt.ui.productos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developercompanyspain.learningchatgpt.data.repository.ProductosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Log

class ProductosViewModel : ViewModel() {
    private val repository = ProductosRepository()
    private val _uiState = MutableStateFlow(ProductosUiState())
    val uiState: StateFlow<ProductosUiState> = _uiState.asStateFlow()

    fun cargarProductos() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(
                    cargando = true,
                    error = null,
                )
                val nuevosProductos = repository.obtenerProductos()
                _uiState.value = _uiState.value.copy(
                    cargando = false,
                    productos = nuevosProductos,
                )
            } catch (e: Exception) {
                Log.e("ProductosViewModel", "Error al cargar productos", e)

                _uiState.value = _uiState.value.copy(
                    cargando = false,
                    error = e.message ?: "Unknow Error",
                )
            }
        }
    }
}
