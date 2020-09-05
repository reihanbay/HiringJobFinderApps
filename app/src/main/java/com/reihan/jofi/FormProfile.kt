package com.reihan.jofi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FormProfile : BaseActivity() {
    var btnSave: Button? = null
    var et_username:EditText? = null
    var et_birth :EditText? = null
    var et_expertise :EditText? = null
    var et_skill :EditText? = null
    var et_summary :EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        findView()
        initListener()
    }

    override fun layoutId(): Int {
        return R.layout.activity_form_profile
    }

    override fun findView() {
        btnSave = findViewById(R.id.btn_login)
        et_username = findViewById(R.id.et_fullname)
        et_birth = findViewById(R.id.et_birth)
        et_expertise = findViewById(R.id.et_expertise)
        et_skill = findViewById(R.id.et_skill)
        et_summary = findViewById(R.id.et_summary)
    }

    override fun initListener() {
        btnSave?.setOnClickListener{
            val usernameEt = et_username?.text.toString()
            val birthEt = et_birth?.text
            val expertiseEt = et_expertise?.text.toString()
            val skillEt = et_skill?.text.toString()
            val summaryEt = et_summary?.text.toString()

            Intent<ProfileScreen>(this)
            put("username", usernameEt)
            put("birth", birthEt.toString())
            put("expertise", expertiseEt)
            put("skill", skillEt)
            put("summary", summaryEt)
            startActivity(start)
        }
    }
}
