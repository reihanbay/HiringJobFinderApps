package com.reihan.jofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : BaseActivity() {

    var btnLogin: Button?= null
    var btnCreate: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        findView()
        initListener()
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun findView() {
        btnLogin = findViewById(R.id.btn_login)
        btnCreate = findViewById(R.id.btn_create)
    }

    override fun initListener() {
        btnLogin?.setOnClickListener {
            Intent<FormProfile>(this)
            startActivity(start)
        }
        btnCreate?.setOnClickListener{
            Intent<Sign_up>(this)
            startActivity(start)
        }
    }
}