package com.example.notepad2025.detalle

sealed class DetalleIntencion {
    object CargarContenido: DetalleIntencion()
    object IrParaAtras: DetalleIntencion()
}