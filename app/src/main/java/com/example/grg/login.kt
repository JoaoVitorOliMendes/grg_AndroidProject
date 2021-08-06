package com.example.grg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {

    private lateinit var btnLogin: Button;
    private lateinit var btnRegister: Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        btnLogin = findViewById<Button>(R.id.btnLogin);
        btnRegister = findViewById<Button>(R.id.btnRegister);

        btnRegister.setOnClickListener{
            var registerIntent = Intent(this,  register::class.java)
            startActivity(registerIntent)
        }
        btnLogin.setOnClickListener{
            var homeIntent = Intent(this,  home::class.java)
            startActivity(homeIntent)
        }
    }
}