package com.example.grg

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class profile : AppCompatActivity() {

    private lateinit var btnUpdate: Button;
    private lateinit var txtNome: EditText;
    private lateinit var txtEmail: EditText;
    private lateinit var txtTelefone: EditText;
    private lateinit var txtCpf: EditText;
    private lateinit var txtSenha: EditText;
    private lateinit var txtConfirmarSenha: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        this.initiateComponents()
        this.autoCompleteFields()

    }

    fun autoCompleteFields() {
        val sharedPref: SharedPreferences = getSharedPreferences("USER", 0)
        //val editor = sharedPref.edit()

        val nome = sharedPref.getString("nome", null)
        val email = sharedPref.getString("email", null)
        val telefone = sharedPref.getString("telefone", null)
        val cpf = sharedPref.getString("cpf", null)
        val senha = sharedPref.getString("senha", null)

        if (nome != null && email != null && senha != null) {
            txtNome.setText(nome)
            txtEmail.setText(email)
            txtTelefone.setText(telefone)
            txtCpf.setText(cpf)
            txtSenha.setText(senha)
        }else {
            Toast.makeText(this@profile,"Usuario nao Logado",Toast.LENGTH_SHORT).show()
            var homeIntent = Intent(this, home::class.java)
            startActivity(homeIntent)
        }
    }

    fun initiateComponents() {
        txtNome = findViewById<EditText>(R.id.txtNomeProfile)
        txtEmail = findViewById<EditText>(R.id.txtEmailProfile)
        txtTelefone = findViewById<EditText>(R.id.txtTelefoneProfile)
        txtCpf = findViewById<EditText>(R.id.txtCpfProfile)
        txtSenha = findViewById<EditText>(R.id.txtSenhaProfile)
        txtConfirmarSenha = findViewById<EditText>(R.id.txtConfirmeSenhaProfile)

        btnUpdate = findViewById<Button>(R.id.btnUpdate);
        btnUpdate.setOnClickListener{
            this.updateFields()
        }
    }

    fun updateFields() {
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
                var homeIntent = Intent(this, home::class.java)
                startActivity(homeIntent)
            }else {
                Toast.makeText(this@profile,"As senhas estao diferentes",Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this@profile,"Campos inconpletos",Toast.LENGTH_SHORT).show()
        }
    }
}