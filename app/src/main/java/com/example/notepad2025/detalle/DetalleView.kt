package com.example.notepad2025.detalle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.compose.rememberNavController
import com.example.notepad2025.Nota
import java.lang.Error

@Composable
fun DetalleView(
    modifier: Modifier = Modifier,
    estado: DetalleEstado,
    onAction: (DetalleIntencion) -> Unit
){
// Función que permite ejecutar código en respuesta a cambios en el ciclo de vida
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(DetalleIntencion.CargarContenido)
    }
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            when(estado){
                DetalleEstado.Vacio -> vacioView()
                DetalleEstado.Cargando -> cargandoView()
                is DetalleEstado.Error -> errorView(estado.error)
                is DetalleEstado.Resultado -> resultadoView(estado.nota)
            }

        }
    }
}

@Composable
fun vacioView(){
    Spacer(modifier = Modifier)
}

@Composable
fun cargandoView(){
    CircularProgressIndicator(
        modifier = Modifier.size(50.dp),
        strokeWidth = 10.dp
    )
}
@Composable
fun errorView(error: String){
    Text(error)
}
@Composable
fun resultadoView(nota: Nota){
    Column {
        Text(nota.titulo)
        Text(nota.texto)
    }
}


@Composable
@Preview
fun DetallePreview(){
    val navController = rememberNavController()
}