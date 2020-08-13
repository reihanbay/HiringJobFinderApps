package com.reihan.jofi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ProfileScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        val tvUsername = findViewById<TextView>(R.id.tv_username_profile)
        val tvExpertise = findViewById<TextView>(R.id.tv_expertise_profile)
        val tvBirth = findViewById<TextView>(R.id.tv_birth_profile)
        val tvSummary = findViewById<TextView>(R.id.tv_content_summary_profile)
        val tvSkill = findViewById<TextView>(R.id.tv_content_skill_profile)

        val username = intent.getStringExtra("username")
        val expertise = intent.getStringExtra("expertise")
        val birth = intent.getStringExtra("birth")
        val summary = intent.getStringExtra("summary")
        val skill = intent.getStringExtra("skill")

        tvUsername.text = username
        tvExpertise.text = expertise
        tvBirth.text = birth
        tvSummary.text = summary
        tvSkill.text = skill

        Log.d("username","$username")
    }
}