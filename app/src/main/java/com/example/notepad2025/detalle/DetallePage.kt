package com.example.notepad2025.detalle

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.notepad2025.Nota

@Composable
fun DetallePage(
    navController: NavController,
    nota: Nota
){
    //Instanciando el ViewModel
    val viewModel = viewModel{
        DetalleViewModel(
            nota = nota,
            navController = navController
        )
    }

    //A la vista le paso el estado y
    DetalleView(
        Modifier,
        estado = viewModel.estado
    ) { intencion ->
        viewModel.ejecutar(intencion)
    }

}