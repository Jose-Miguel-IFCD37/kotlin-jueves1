package com.visualstudioex3.jueves1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPerfilUsuario()
        }
    }
}

@Composable
fun AppPerfilUsuario() {
    // 1. Estado de la aplicación: define qué se muestra
    var estadoNombre by remember { mutableStateOf("Desconectado") }
    var colorEstado by remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 2. Tarjeta Personalizada (UI Custom)
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth().height(120.dp),
            colors = CardDefaults.cardColors(containerColor = colorEstado.copy(alpha = 0.2f))
        ) {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Círculo que simula el avatar con el color del estado
                Box(
                    modifier = Modifier.size(60.dp).background(colorEstado, CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("Usuario Pro", style = MaterialTheme.typography.headlineSmall)
                    Text("Estado: $estadoNombre", color = Color.DarkGray)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // 3. Controles para cambiar el aspecto configurable
        Text("Cambiar Estado:", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { estadoNombre = "Disponible"; colorEstado = Color.Green }) {
                Text("Online")
            }
            Button(onClick = { estadoNombre = "Ocupado"; colorEstado = Color.Red }) {
                Text("Busy")
            }
            Button(onClick = { estadoNombre = "Ausente"; colorEstado = Color.Yellow }) {
                Text("Away")
            }
        }
    }
}