package com.example.growzen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Toast
import com.example.growzen.databinding.ActivityRegistrasiBinding

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrasiBinding
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(this)
        binding.btnRegister.setOnClickListener{
            val signupFirstName = binding.etFirstName.text.toString()
            val signupLastName = binding.etLastName.text.toString()
            val signupEmail = binding.etEmail.text.toString()
            val signupPassword = binding.etPassword.text.toString()
            signupDatabase(signupFirstName, signupLastName, signupEmail, signupPassword)
        }
    }

    private fun signupDatabase(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ) {
        if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            val result = dbHelper.addUser(firstName, lastName, email, password)

            if (result != -1L) {
                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Registrasi Gagal", Toast.LENGTH_SHORT).show()

            }
        }
    }
}