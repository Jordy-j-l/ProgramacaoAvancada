package com.example.continentesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
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
    Text("Olá Continentes!", style = MaterialTheme.typography.headlineMedium)
}

@Preview(showBackground = true)
@Composable
fun ContinentesAppPreview() {
    ContinentesAppTheme {
        ContinentesApp()
    }
}
