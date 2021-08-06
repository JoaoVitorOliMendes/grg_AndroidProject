package com.example.grg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class profile : AppCompatActivity() {

    private lateinit var btnUpdate: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnUpdate = findViewById<Button>(R.id.btnUpdate);
        btnUpdate.setOnClickListener{
            var homeIntent = Intent(this, home::class.java)
            startActivity(homeIntent)
        }
    }
}