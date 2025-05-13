package com.example.continentesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.continentesapp.ui.theme.ContinentesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContinentesAppTheme {
                ContinentesApp()
            }
        }
    }
}

@Composable
fun ContinentesApp() {
    val continentes = listOf("África", "Europa", "América", "Ásia")
    var continenteSelecionado by remember { mutableStateOf<String?>(null) }

    if (continenteSelecionado == null) {
        // Menu principal
        ContinenteMenu(onContinenteSelecionado = { continenteSelecionado = it })
    } else {
        // Para quando você implementar as páginas dos continentes
        // ContinenteScreen(continente = continenteSelecionado!!, onVoltar = { continenteSelecionado = null })
    }
}

@Composable
fun ContinenteMenu(onContinenteSelecionado: (String) -> Unit) {
    val continentes = listOf("África", "Europa", "América", "Ásia")

    Box(
        modifier = Modifier
            .fillMaxSize()  // Asegura que o Box preencha toda a tela
    ) {
        // Adiciona o background da imagem, ajustado para preencher toda a tela
        Image(
            painter = painterResource(id = R.drawable.backgrounddetailold),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds  // Preenche toda a tela sem bordas
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            continentes.forEach { continente ->
                Button(
                    onClick = { onContinenteSelecionado(continente) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)  // Aumentando o tamanho do botão
                        .padding(vertical = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6B4226)) // Cor castanha
                ) {
                    Text(
                        text = continente,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp) // Negrito e maior fonte
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContinentesAppPreview() {
    ContinentesAppTheme {
        ContinenteMenu(onContinenteSelecionado = {})
    }
}
