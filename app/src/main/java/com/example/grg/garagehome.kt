package com.example.grg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class garagehome : AppCompatActivity() {

    private lateinit var menu: ImageButton;
    private lateinit var btnNewGarage: Button;
    private lateinit var btnGarageBackHome: Button;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garagehome)


        initbuttons()
    }

    private fun initbuttons() {
        menu = findViewById<ImageButton>(R.id.menu);
        btnNewGarage = findViewById<Button>(R.id.btnNewGarages);
        btnGarageBackHome = findViewById<Button>(R.id.btnGarageBackHome);

        btnNewGarage.setOnClickListener{
            val addGarage = Intent(this, addgarages::class.java)
            startActivity(addGarage)
        }
        btnGarageBackHome.setOnClickListener{
            val homeIntent = Intent(this, home::class.java)
            startActivity(homeIntent)
        }
        menu.setOnClickListener{
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.garage_menu_delete -> {
                        Toast.makeText(this, "deletar", Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.garage_menu_profile -> {
                        Toast.makeText(this, "profile", Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.garagemenu)
            popupMenu.show()
        }
    }
}