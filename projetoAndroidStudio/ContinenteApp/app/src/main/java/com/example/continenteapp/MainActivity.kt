package com.example.continenteapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.continenteapp.ui.theme.ContinenteAppTheme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContinenteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppController(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun AppController(context: Context) {
    var showAfrica by remember { mutableStateOf(false) }
    var showEuropa by remember { mutableStateOf(false) }
    var showAmerica by remember { mutableStateOf(false) }
    var showAsia by remember { mutableStateOf(false) }

    when {
        showAfrica -> ScreenAfrica(onBack = { showAfrica = false })
        showEuropa -> ScreenEuropa(onBack = { showEuropa = false })
        showAmerica -> ScreenAmerica(onBack = { showAmerica = false })
        showAsia -> ScreenAsia(onBack = { showAsia = false })
        else -> MainMenu(
            onAfricaClick = { showAfrica = true },
            onEuropaClick = { showEuropa = true },
            onAmericaClick = { showAmerica = true },
            onAsiaClick = { showAsia = true }
        )
    }
}

@Composable
fun MainMenu(
    onAfricaClick: () -> Unit,
    onEuropaClick: () -> Unit,
    onAmericaClick: () -> Unit,
    onAsiaClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onAfricaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF393A)
                )
            ) {
                Text(text = "Africa")
            }

            Button(
                onClick = onEuropaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF70C4E5)
                )
            ) {
                Text(text = "Europa")
            }

            Button(
                onClick = onAsiaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3ECEB5)
                )
            ) {
                Text(text = "Asia")
            }

            Button(
                onClick = onAmericaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD14358)
                )
            ) {
                Text(text = "America")
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ScreenAfrica(onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        ContinentScreen(
            continentPrefix = "africa",
            contentDescription = "Africa Background",
            onBack = onBack
        )
        BackHandler(onBack = onBack)
    }
}

@Composable
fun ScreenEuropa(onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        ContinentScreen(
            continentPrefix = "europa",
            contentDescription = "Europa Background",
            onBack = onBack
        )
        BackHandler(onBack = onBack)
    }
}

@Composable
fun ScreenAmerica(onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        ContinentScreen(
            continentPrefix = "america",
            contentDescription = "America Background",
            onBack = onBack
        )
        BackHandler(onBack = onBack)
    }
}

@Composable
fun ScreenAsia(onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        ContinentScreen(
            continentPrefix = "asia",
            contentDescription = "Asia Background",
            onBack = onBack
        )
        BackHandler(onBack = onBack)
    }
}


@Composable
fun ContinentScreen(
    continentPrefix: String,
    contentDescription: String,
    onBack: () -> Unit
) {
    val imageResources = remember {
        listOf(
            getResourceId("${continentPrefix}_1"),
            getResourceId("${continentPrefix}_2"),
            getResourceId("${continentPrefix}_3"),
            getResourceId("${continentPrefix}_4")
        ).filter { it != 0 }
    }

    var currentImage by remember { mutableStateOf(when (continentPrefix){
        "africa","europa","asia","america"-> getResourceId("bg_${continentPrefix}")
         else -> imageResources.random()
    }) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )

        Button(
            onClick = {
                var newImage: Int
                do {
                    newImage = imageResources.random()
                } while (newImage == currentImage)
                currentImage = newImage
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = when (continentPrefix) {
                    "africa" -> Color(0xFF452F3C)
                    "europa" -> Color(0xFFCA4C1D)
                    "asia" -> Color(0xFF354D50)
                    "america" -> Color(0xFFF1BF5F)
                    else -> Color.Gray
                }
            )
        ) {
            Text(text = "Explorar",color= colorResource(id=R.color.white))

        }
    }

    BackHandler(onBack = onBack)
}


// Função auxiliar para obter o ID do recurso pelo nome
fun getResourceId(resourceName: String): Int {
    return try {
        R.drawable::class.java.getField(resourceName).getInt(null)
    } catch (e: Exception) {
        0 // Retorna 0 se o recurso não for encontrado
    }
}

// Previews

@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    ContinenteAppTheme {
        MainMenu(
            onAfricaClick = {},
            onEuropaClick = {},
            onAmericaClick = {},
            onAsiaClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContinentScreenAfrica() {
    ContinenteAppTheme {
        ContinentScreen(
            continentPrefix = "africa",
            contentDescription = "Africa Preview",
            onBack = {}
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewContinentScreenEuropa() {
    ContinenteAppTheme {
        ContinentScreen(
            continentPrefix = "europa",
            contentDescription = "Europa Preview",
            onBack = {}
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewContinentScreenAsia() {
    ContinenteAppTheme {
        ContinentScreen(
            continentPrefix = "asia",
            contentDescription = "Asia Preview",
            onBack = {}
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewContinentScreenAmerica() {
    ContinenteAppTheme {
        ContinentScreen(
            continentPrefix = "america",
            contentDescription = "America Preview",
            onBack = {}
        )
    }
}