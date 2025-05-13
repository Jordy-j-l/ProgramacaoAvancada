package com.example.continentesapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ContinenteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continente)

        val continente = intent.getStringExtra("continente") ?: "africa"

        val layout = findViewById<android.widget.RelativeLayout>(R.id.layoutContinente)

        when (continente) {
            "africa" -> layout.setBackgroundResource(R.drawable.bg_africa)
            "europa" -> layout.setBackgroundResource(R.drawable.bg_europa)
            "america" -> layout.setBackgroundResource(R.drawable.bg_america)
            "asia" -> layout.setBackgroundResource(R.drawable.bg_asia)
        }

        val btnExplore = findViewById<Button>(R.id.btnExplore)
        // Vamos configurar o botão já no próximo passo
    }
}
