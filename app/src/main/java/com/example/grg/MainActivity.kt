package com.example.grg

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById<Button>(R.id.btnLogin);
        btnStart.setOnClickListener{
            var intent: Intent = Intent(this, login::class.java);
            startActivity(intent);
        }
    }
}