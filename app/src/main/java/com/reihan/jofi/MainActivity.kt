package com.reihan.jofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSplash = findViewById<Button>(R.id.splash)
        val btnOnBoard = findViewById<Button>(R.id.onBoard)
        val btnLogin = findViewById<Button>(R.id.login)
        val btnReg = findViewById<Button>(R.id.register)
        val btnForm = findViewById<Button>(R.id.form)
        val btnProfile = findViewById<Button>(R.id.profile)

        btnSplash.setOnClickListener{
            val intentSplash = Intent(this, Splash::class.java)
            startActivity(intentSplash)
        }

        btnOnBoard.setOnClickListener{
            val intentOnBoard = Intent(this, AppIntroScreen::class.java)
            startActivity(intentOnBoard)
        }

        btnReg.setOnClickListener{
            val intentRegister = Intent(this, Sign_up::class.java)
            startActivity(intentRegister)
        }

        btnLogin.setOnClickListener{
            val intentLogin = Intent(this, Login::class.java)
            startActivity(intentLogin)
        }

        btnForm.setOnClickListener{
            val intentForm = Intent(this, FormProfile::class.java)
            startActivity(intentForm)
        }

        btnProfile.setOnClickListener{
            val intentProfile = Intent(this, ProfileScreen::class.java)
            startActivity(intentProfile)
        }
    }
}