package com.example.continentesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.continentesapp.ui.theme.ContinentesAppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
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
        // Tela do continente
        ContinenteScreen(continente = continenteSelecionado!!, onVoltar = { continenteSelecionado = null })
    }
}
@Composable
fun ContinenteMenu(onContinenteSelecionado: (String) -> Unit) {
    val continentes = listOf("África", "Europa", "América", "Ásia")

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
                    .padding(vertical = 8.dp)
            ) {
                Text(text = continente)
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


@Composable
fun ContinenteScreen(continente: String, onVoltar: () -> Unit) {
    val imagens = when (continente.lowercase()) {
        "áfrica" -> listOf(R.drawable.africa_1, R.drawable.africa_2, R.drawable.africa_3, R.drawable.africa_4)
        "europa" -> listOf(R.drawable.europa_1, R.drawable.europa_2, R.drawable.europa_3, R.drawable.europa_4)
        "américa" -> listOf(R.drawable.america_1, R.drawable.america_2, R.drawable.america_3, R.drawable.america_4)
        "ásia" -> listOf(R.drawable.asia_1, R.drawable.asia_2, R.drawable.asia_3, R.drawable.asia_4)
        else -> emptyList()
    }

    var imagemAtual by remember { mutableStateOf(imagens.random()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = continente, style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imagemAtual),
            contentDescription = "Imagem do continente",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { imagemAtual = imagens.random() }) {
            Text(text = "Explorar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onVoltar) {
            Text(text = "Voltar")
        }
    }
}

