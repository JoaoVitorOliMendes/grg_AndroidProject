package com.example.grg

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class register : AppCompatActivity() {

    private lateinit var btnRegister: Button;
    private lateinit var txtNome: EditText;
    private lateinit var txtEmail: EditText;
    private lateinit var txtTelefone: EditText;
    private lateinit var txtCpf: EditText;
    private lateinit var txtSenha: EditText;
    private lateinit var txtConfirmarSenha: EditText;

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)


        this.initiateComponents()
    }

    fun initiateComponents() {
        btnRegister = findViewById<Button>(R.id.btnRegister)
        txtNome = findViewById<EditText>(R.id.txtNomeRegister)
        txtEmail = findViewById<EditText>(R.id.txtEmailRegister)
        txtTelefone = findViewById<EditText>(R.id.txtTelefoneRegister)
        txtCpf = findViewById<EditText>(R.id.txtCpfRegister)
        txtSenha = findViewById<EditText>(R.id.txtSenhaRegister)
        txtConfirmarSenha = findViewById<EditText>(R.id.txtConfirmarSenhaRegister)

        btnRegister.setOnClickListener{
            this.insertValuesIntoSharedPref()
            Toast.makeText(this@register,"Cadastrado",Toast.LENGTH_SHORT).show()
            var intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }

    fun insertValuesIntoSharedPref() {
        val sharedPref: SharedPreferences = getSharedPreferences("USER", 0)
        val editor = sharedPref.edit()

        val nome = txtNome.editableText.toString()
        val email = txtEmail.editableText.toString()
        val telefone = txtTelefone.editableText.toString()
        val cpf = txtCpf.editableText.toString()
        val senha = txtSenha.editableText.toString()
        val confirmarSenha = txtConfirmarSenha.editableText.toString()

        if(nome != null && email != null && senha != null) {
            if (senha.equals(confirmarSenha)) {
                editor.putString("nome", nome)
                editor.putString("email", email)
                editor.putString("telefone", telefone)
                editor.putString("cpf", cpf)
                editor.putString("senha", senha)

                editor.commit()
            }else {
                Toast.makeText(this@register,"As senhas estao diferentes",Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this@register,"Campos inconpletos",Toast.LENGTH_SHORT).show()
        }
    }
}