package com.example.storyapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var buttonSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi view
        buttonSignUp = findViewById(R.id.buttonSignUp)

        // Set onClickListener untuk tombol Sign Up
        buttonSignUp.setOnClickListener {
            // Lakukan proses sign up
            performSignUp()
        }
    }

    private fun performSignUp() {
        // Lakukan proses sign up (misalnya, menavigasi ke halaman sign up atau mengirim data ke server)
        // Implementasikan sesuai kebutuhan aplikasi Anda
    }
}
