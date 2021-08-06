package com.example.grg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class addgarages : AppCompatActivity() {

    private lateinit var btnAddGarage: Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addgarages)

        btnAddGarage = findViewById<Button>(R.id.btnAddGarage)
        btnAddGarage.setOnClickListener{
            val garageIntent = Intent(this, garagehome::class.java)
            startActivity(garageIntent)
        }
    }
}