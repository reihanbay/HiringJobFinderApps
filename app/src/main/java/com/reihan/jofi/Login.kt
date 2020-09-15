package com.reihan.jofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.reihan.jofi.databinding.ActivityLoginBinding
import com.reihan.jofi.utils.sharedpreferences.Constants
import com.reihan.jofi.utils.sharedpreferences.PreferenceHelper
import kotlinx.android.synthetic.main.activity_login.*

class Login : BaseActivity() {

    lateinit var sharedPref : PreferenceHelper
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())
        initListener()
    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constants.PREF_IS_LOGIN)!!){
            moveIntent()
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }


    override fun initListener() {
        binding.tvCreate.setOnClickListener{
            Intent<Sign_up>(this)
            startActivity(start)
        }
        sharedPref = PreferenceHelper(this)
        val getEmail = sharedPref.getString(Constants.PREF_EMAIL)
        val getPass = sharedPref.getString(Constants.PREF_PASSWORD)
        binding.btnLogin.setOnClickListener {
            if (et_email.text.toString() == getEmail && et_password.text.toString() == getPass){
                sharedPref.put(Constants.PREF_IS_LOGIN, true)
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                moveIntent()
            } else {
                Toast.makeText(this, "Incorrect Email or Password Input!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun moveIntent(){
        IntentStart<MainActivity>(this)
        finish()
    }
}