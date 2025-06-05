package com.example.notepad2025

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetalleDeNotaView(
    navController: NavController,
    nota: Nota,
    modifier: Modifier = Modifier
){
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text(nota.titulo)
            Text("Hola soy el detalle de la nota")

        }
    }
}


@Composable
@Preview
fun DetalleDeNotaPreview(){
    val navController = rememberNavController()
    DetalleDeNotaView(navController, nota = Nota("",""))
}