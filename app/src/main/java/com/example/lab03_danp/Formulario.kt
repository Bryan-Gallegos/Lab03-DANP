package com.example.lab03_danp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre: String,
    funNombre: (String) -> Unit,
    email: String,
    funEmail: (String) -> Unit,
    apellido: String,
    funApellido: (String) -> Unit,
    sangre: String,
    funSangre: (String) ->Unit,
    telefono: String,
    funTelefono: (String) -> Unit,
    fecha: String,
    funFecha: (String) -> Unit,
    monto: String,
    funMonto: (String) -> Unit,
    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaAsistentes: MutableList<Asistente>,
    funResetCampos: () -> Unit
) {
    //Obtener Nombre
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Ingrese su Nombre") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Obtener Apellido
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = apellido,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funApellido(it) },
        label = { Text(text = "Ingrese su Apellido") },
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Obtener Fecha
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fecha,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funFecha(it) },
        label = { Text(text = "Fecha de Inscripción") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Obtener sangre
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = sangre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funSangre(it) },
        label = { Text(text = "Tipo de Sangre") },
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Obtener telefono
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTelefono(it) },
        label = { Text(text = "Número de Telefono") },
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Obtener Monto
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = monto,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funMonto(it) },
        label = { Text(text = "Monto Pagado") },
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Obtener Email
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funEmail(it) },
        label = { Text(text = "Ingrese su Email") }
    )
    Spacer(modifier = Modifier.padding(vertical = .2.dp))

    //Botones
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
        onClick = {
            if (isEditando) {
                editAsistente(nombre, apellido, fecha, sangre, telefono, monto, email, listaAsistentes)
                funTextButton("Agregar Asistente")
                funIsEditando()

            } else {
                addAsistente(nombre, apellido, fecha, sangre, telefono, monto, email, listaAsistentes)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}