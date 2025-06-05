package com.example.notepad2025.detalle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notepad2025.Nota
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetalleViewModel(
    val nota: Nota,
    val navController: NavController
): ViewModel() {

    var estado by mutableStateOf<DetalleEstado>(DetalleEstado.Vacio)

    fun ejecutar(intencion: DetalleIntencion) {
        when (intencion) {
            DetalleIntencion.IrParaAtras -> irParaAtras()
            DetalleIntencion.CargarContenido -> CargarContenido()
        }
    }


    private fun irParaAtras() {
        navController.popBackStack()
    }

    private fun CargarContenido() {
        //simulo que tarda un poco
        estado = DetalleEstado.Cargando
        viewModelScope.launch {
            delay(2000)
            estado = DetalleEstado.Resultado(nota)
        }

    }
}