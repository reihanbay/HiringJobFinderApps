package com.reihan.jofi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ProfileScreen : BaseActivity() {
    var tvUsername : TextView? = null
    var tvExpertise: TextView? = null
    var tvBirth : TextView? = null
    var tvSummary : TextView? = null
    var tvSkill : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        findView()
        initListener()
    }

    override fun layoutId(): Int {
        return R.layout.activity_profile_screen
    }

    override fun findView() {
        tvUsername = findViewById(R.id.tv_username_profile)
        tvExpertise = findViewById(R.id.tv_expertise_profile)
        tvBirth = findViewById(R.id.tv_birth_profile)
        tvSummary = findViewById(R.id.tv_content_summary_profile)
        tvSkill = findViewById(R.id.tv_content_skill_profile)
    }

    override fun initListener() {
        val username = intent.getStringExtra("username")
        val expertise = intent.getStringExtra("expertise")
        val birth = intent.getStringExtra("birth")
        val summary = intent.getStringExtra("summary")
        val skill = intent.getStringExtra("skill")

        tvUsername?.text = username
        tvExpertise?.text = expertise
        tvBirth?.text = birth
        tvSummary?.text = summary
        tvSkill?.text = skill

        Log.d("username","$username")
    }
}