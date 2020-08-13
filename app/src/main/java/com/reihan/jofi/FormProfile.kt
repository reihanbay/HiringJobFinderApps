package com.reihan.jofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_form_profile.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class FormProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_profile)

        val btnSave = findViewById<Button>(R.id.btn_login)

        val et_username = findViewById<EditText>(R.id.et_fullname)
        val et_birth = findViewById<EditText>(R.id.et_birth)
        val et_expertise = findViewById<EditText>(R.id.et_expertise)
        val et_skill = findViewById<EditText>(R.id.et_skill)
        val et_summary = findViewById<EditText>(R.id.et_summary)

        btnSave.setOnClickListener{
            val usernameEt = et_username.text.toString()
            val birthEt = et_birth.text
            val expertiseEt = et_expertise.text.toString()
            val skillEt = et_skill.text.toString()
            val summaryEt = et_summary.text.toString()

            val intentSave = Intent(this, ProfileScreen::class.java)
            intentSave.putExtra("username", "$usernameEt")
            intentSave.putExtra("birth", "$birthEt")
            intentSave.putExtra("expertise", "$expertiseEt")
            intentSave.putExtra("skill", "$skillEt")
            intentSave.putExtra("summary", "$summaryEt")
            startActivity(intentSave)
        }
    }
}