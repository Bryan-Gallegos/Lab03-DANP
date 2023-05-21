package com.example.lab03_danp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab03_danp.ui.theme.LAB03_DANPTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            LAB03_DANPTheme{

                val listaAsistentes = remember { mutableStateListOf<Asistente>() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ScreenCRUD(listaAsistentes)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD(listaAsistentes: MutableList<Asistente>) {

    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var sangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Usuario") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            Formulario(
                nombre = nombre,
                funNombre = { nombre = it },
                apellido = apellido,
                funApellido = {apellido = it},
                fecha = fecha,
                funFecha = {fecha = it},
                sangre = sangre,
                funSangre = {sangre = it},
                telefono = telefono,
                funTelefono = {telefono = it},
                monto = monto,
                funMonto = {monto = it},
                email = email,
                funEmail = { email = it },
                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaAsistentes = listaAsistentes,
                funResetCampos = {
                    nombre = ""
                    apellido = ""
                    fecha = ""
                    sangre = ""
                    telefono = ""
                    monto = ""
                    email = ""
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    items(listaAsistentes) { asistente ->

                        CardAsistente(
                            funNombre = { nombre = it },
                            funApellido = { apellido = it},
                            funFecha = {fecha = it},
                            funSangre = {sangre = it},
                            funTelefono = {telefono = it},
                            funMonto = {monto = it},
                            funEmail =  { email = it },
                            asistente = asistente,
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funDeleteAsistente = { deleteAsistente(it, listaAsistentes) }
                        )
                    }
                }
            }
        }
    }
}

fun addAsistente(nombre: String, apellido: String,  fecha: String, sangre: String, telefono: String, monto:String, email: String, listaAsistentes: MutableList<Asistente>) {
    listaAsistentes.add(Asistente(nombre, apellido, fecha, sangre, telefono, monto, email))
}

fun editAsistente(nombre: String, apellido: String,  fecha: String, sangre: String, telefono: String, monto:String, email: String, listaAsistentes: MutableList<Asistente>) {
    listaAsistentes.forEach { asistente ->
        if (asistente.nombre == nombre) {
            asistente.apellido = apellido
            asistente.fecha = fecha
            asistente.sangre = sangre
            asistente.telefono = telefono
            asistente.monto = monto
            asistente.email = email
        }
    }
}

fun deleteAsistente(nombre: String, listaAsistentes: MutableList<Asistente>) {
    listaAsistentes.forEach { asistente ->
        if (asistente.nombre == nombre) {
            listaAsistentes.remove(asistente)
        }
    }
}
