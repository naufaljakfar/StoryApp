package com.example.storyapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.storyapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignIn: Button
    private lateinit var buttonSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSignIn = findViewById(R.id.buttonSignIn)
        buttonSignUp = findViewById(R.id.TextSignUp)

        binding.TextSignUp.setOnClickListener {
            val intent = Intent(this@SignInActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Set TextWatcher pada editTextPassword
        editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Kosongkan
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Kosongkan
            }

            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()
                if (password.length < 8) {
                    editTextPassword.error = "Password must be at least 8 characters"
                } else {
                    editTextPassword.error = null
                }
            }
        })

        // Set onClickListener untuk tombol Sign In
        buttonSignIn.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Lakukan validasi email dan password
            if (isValidEmail(email) && isValidPassword(password)) {
                // Lakukan proses sign in
                performSignIn(email, password)
            } else {
                Toast.makeText(this, "Please fix the errors.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        // Lakukan validasi email (contoh sederhana)
        return email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Lakukan validasi password (contoh sederhana)
        return password.length >= 8
    }

    private fun performSignIn(email: String, password: String) {
        // Lakukan proses sign in (misalnya, menggunakan API atau autentikasi)
        // Implementasikan sesuai kebutuhan aplikasi Anda
        Toast.makeText(this@SignInActivity, "Sign in successful.", Toast.LENGTH_SHORT).show()
    }

}



