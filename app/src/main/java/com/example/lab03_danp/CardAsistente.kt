package com.example.lab03_danp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardAsistente(
    funNombre: (String) -> Unit,
    funApellido: (String) -> Unit,
    funSangre: (String) -> Unit,
    funTelefono: (String) -> Unit,
    funMonto: (String) -> Unit,
    funEmail: (String) -> Unit,
    funFecha: (String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,
    asistente: Asistente,
    funDeleteAsistente: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.Center
        ) {
            Text(
                text = asistente.nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = asistente.apellido,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = asistente.email,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = {
                        funNombre(asistente.nombre)
                        funApellido(asistente.apellido)
                        funEmail(asistente.email)
                        funFecha(asistente.fecha)
                        funSangre(asistente.sangre)
                        funTelefono(asistente.telefono)
                        funMonto(asistente.monto)
                        funTextButton("Editar Asistente")
                        funIsEditando(true)
                    }
                ) {
                    Text(
                        color = Color.Black,
                        text = "Edit"
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funDeleteAsistente(asistente.nombre)
                    }
                ) {
                    Text(
                        color = Color.LightGray,
                        text = "Delete"
                    )
                }
            }
        }
    }
}