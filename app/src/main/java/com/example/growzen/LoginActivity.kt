package com.example.growzen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.growzen.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(this)

        binding.btnLogin.setOnClickListener{
            val loginUsername = binding.email.text.toString()
            val loginPassword = binding.pass.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }
        binding.createAccount.setOnClickListener{
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loginDatabase(email: String, password: String){
        val userExists = dbHelper.getUserByEmailAndPassword(email, password)
        if (userExists){
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Periksa Kembali Username Dan Password", Toast.LENGTH_SHORT).show()
        }
    }
}