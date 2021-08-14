package com.example.grg

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class login : AppCompatActivity() {

    private lateinit var btnLogin: Button;
    private lateinit var btnRegister: Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        this.checkIfLogged()

        btnLogin = findViewById<Button>(R.id.btnLogin);
        btnRegister = findViewById<Button>(R.id.btnRegister);

        btnRegister.setOnClickListener{
            var registerIntent = Intent(this,  register::class.java)
            startActivity(registerIntent)
        }
        btnLogin.setOnClickListener{
            this.checkIfLogged()
        //    var homeIntent = Intent(this,  home::class.java)
        //   startActivity(homeIntent)
        }
    }

    fun checkIfLogged() {
        val sharedPref: SharedPreferences = getSharedPreferences("USER", 0)

        if (sharedPref.getString("nome", null) != null) {
            Toast.makeText(this@login,"Usuario Logado",Toast.LENGTH_SHORT).show()
            var homeIntent = Intent(this,  home::class.java)
            startActivity(homeIntent)
        }else{
            Toast.makeText(this@login,"Cadastre-se",Toast.LENGTH_SHORT).show()
        }
    }
}