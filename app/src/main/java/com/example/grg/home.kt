package com.example.grg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class home : AppCompatActivity() {

    private lateinit var btnProfile : Button;
    private lateinit var btnGarages : Button;
    private lateinit var btnInfo : Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initVars();
    }

    private fun initVars() {
        btnProfile = findViewById<Button>(R.id.btnProfile);
        btnGarages = findViewById<Button>(R.id.btnGarages);
        btnInfo = findViewById<Button>(R.id.btnInfo);

        btnProfile.setOnClickListener{
            var profileIntent = Intent(this, profile::class.java)
            startActivity(profileIntent)
        }
        btnGarages.setOnClickListener{
            var garagesIntent = Intent(this, garagehome::class.java)
            startActivity(garagesIntent)
        }
    }
}