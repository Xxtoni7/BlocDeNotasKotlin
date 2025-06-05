package com.example.notepad2025.detalle

import com.example.notepad2025.Nota

sealed class DetalleEstado {
    data object Vacio: DetalleEstado()
    data object  Cargando: DetalleEstado()
    data class Error(val error:String): DetalleEstado()
    data class Resultado(val nota: Nota): DetalleEstado()
}