package com.reihan.jofi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.reihan.jofi.databinding.ActivitySignUpBinding
import com.reihan.jofi.utils.sharedpreferences.Constants
import com.reihan.jofi.utils.sharedpreferences.PreferenceHelper


class Sign_up : BaseActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var sharedPref : PreferenceHelper
    var btnSignUp: Button? = null
    var btnLogin: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutId())

        sharedPref = PreferenceHelper(this)

        binding.btnCreate.setOnClickListener {
            if (binding.etUsername.text.isNotEmpty() && binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()){
                sharedPref.put(Constants.PREF_USERNAME, binding.etUsername.text.toString())
                sharedPref.put(Constants.PREF_EMAIL, binding.etEmail.text.toString())
                sharedPref.put(Constants.PREF_PASSWORD, binding.etPassword.text.toString())

                Toast.makeText(this, "Register Success", Toast.LENGTH_LONG).show()
                IntentStart<Login>(this)
            }
        }

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
        btnLogin?.setOnClickListener {
            Intent<Login>(this)
            startActivity(start)
        }
    }
}