package com.example.continentesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAfrica = findViewById<Button>(R.id.btnAfrica)
        val btnEuropa = findViewById<Button>(R.id.btnEuropa)
        val btnAmerica = findViewById<Button>(R.id.btnAmerica)
        val btnAsia = findViewById<Button>(R.id.btnAsia)

        val intent = Intent(this, ContinenteActivity::class.java)

        btnAfrica.setOnClickListener {
            val intent = Intent(this, ContinenteActivity::class.java)
            intent.putExtra("continente", "africa")
            startActivity(intent)
        }

        btnEuropa.setOnClickListener {
            val intent = Intent(this, ContinenteActivity::class.java)
            intent.putExtra("continente", "europa")
            startActivity(intent)
        }

        btnAmerica.setOnClickListener {
            val intent = Intent(this, ContinenteActivity::class.java)
            intent.putExtra("continente", "america")
            startActivity(intent)
        }

        btnAsia.setOnClickListener {
            val intent = Intent(this, ContinenteActivity::class.java)
            intent.putExtra("continente", "asia")
            startActivity(intent)
        }

    }
}
