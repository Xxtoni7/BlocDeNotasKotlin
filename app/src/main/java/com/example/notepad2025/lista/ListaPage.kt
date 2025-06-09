package com.example.notepad2025.lista

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.notepad2025.Nota

@Composable
fun ListaPage(
    navController: NavController,
    listaDeNotas: List<Nota>,
) {
    //Instanciando el ViewModel
    val viewModel = viewModel{
        ListaViewModel(
            navController = navController,
            listaDeNotas = listaDeNotas
        )
    }


    //A la vista le paso el estado y por funcion lamda le paso la intencion al viewModel
    ListaDeNotasView(
        estado = viewModel.estado
    ) { intencion ->
        viewModel.ejecutar(intencion)
    }

}