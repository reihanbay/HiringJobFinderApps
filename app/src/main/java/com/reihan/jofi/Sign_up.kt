package com.reihan.jofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Sign_up : BaseActivity() {

    var btnSignUp: Button? = null
    var btnLogin: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        findView()
        initListener()
    }

    override fun layoutId(): Int {
        return R.layout.activity_sign_up
    }

    override fun findView() {
        btnSignUp = findViewById(R.id.btn_create)
        btnLogin = findViewById(R.id.tv_toLogin)
    }

    override fun initListener() {
        btnSignUp?.setOnClickListener {
            Intent<Login>(this)
            startActivity(start)
        }
        btnLogin?.setOnClickListener {
            Intent<Login>(this)
            startActivity(start)
        }
    }
}