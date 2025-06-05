package com.example.notepad2025

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notepad2025.ui.theme.NotePad2025Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaNota(
    navController: NavController,
    modifier: Modifier = Modifier,
    onNuevaNota: (Nota) -> Unit
) {

    var textTittle by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Soy una topBar")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textTittle,
                onValueChange = { newText -> textTittle = newText },
                label = { Text("Ingresar Titulo") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Ingresar Texto") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // poBackStack significa que vaya para atras
                    navController.popBackStack()
                    onNuevaNota(
                        Nota(titulo = textTittle, texto = text)
                    )
                }, modifier = Modifier.align(Alignment.End)
            ) {
                Text("Crear Nota")
            }
        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotePad2025Theme {
        NuevaNota(
            rememberNavController()
        ) { _-> } //Esta linea no hace nada, simplemente lo pongo xq necesito poner un parametro
    }
}