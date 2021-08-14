package com.example.grg

import android.content.Intent
import android.content.SharedPreferences
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

        val sharedPref: SharedPreferences = getSharedPreferences("USER", 0)
        val editor = sharedPref.edit()
        editor.clear()
        editor.commit()

        btnStart = findViewById<Button>(R.id.btnLogin);
        btnStart.setOnClickListener{
            var intent: Intent = Intent(this, login::class.java);
            startActivity(intent);
        }
    }
}