package com.example.notepad2025.lista

import com.example.notepad2025.Nota

sealed class ListaIntencion {
    object CargarLista: ListaIntencion()
    object NuevaNota: ListaIntencion()
    class NotaSeleccionada(val nota: Nota): ListaIntencion()

}