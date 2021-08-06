package com.example.grg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class register : AppCompatActivity() {

    private lateinit var btnRegister: Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener{
            var intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}