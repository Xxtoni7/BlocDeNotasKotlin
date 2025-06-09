package com.example.notepad2025.lista

import com.example.notepad2025.Nota

sealed class ListaEstado {
    data object Vacio: ListaEstado()
    data object  Cargando: ListaEstado()
    data class Error(val error:String): ListaEstado()
    data class Resultado(val listaDeNotas: List<Nota>): ListaEstado()
}