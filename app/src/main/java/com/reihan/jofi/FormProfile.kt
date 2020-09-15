package com.reihan.jofi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.reihan.jofi.databinding.ActivityFormProfileBinding
import kotlinx.android.synthetic.main.activity_main.*

class FormProfile : BaseActivity() {


    private lateinit var binding: ActivityFormProfileBinding
    override fun layoutId(): Int {
        return R.layout.activity_form_profile
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())

        var et_username = binding.etFullname
        var et_birth = binding.etBirth
        var et_expertise = binding.etExpertise
        var et_skill = binding.etSkill
        var et_summary = binding.etSummary

        binding.btnSave.setOnClickListener {
            val usernameEt = et_username.text.toString()
            val birthEt = et_birth.text
            val expertiseEt = et_expertise.text.toString()
            val skillEt = et_skill.text.toString()
            val summaryEt = et_summary.text.toString()

            val ProfileForm = ProfileScreen()
            val bundle = Bundle()
            bundle.putString(ProfileScreen.Username, "$usernameEt")
            bundle.putString(ProfileScreen.Birth, "$birthEt")
            bundle.putString(ProfileScreen.Expertise, "$expertiseEt")
            bundle.putString(ProfileScreen.Skill, "$skillEt")
            bundle.putString(ProfileScreen.Summary, "$summaryEt")

            ProfileForm.arguments = bundle
            MainActivity().bottom_navigation.menu.findItem(R.id.ic_profileFragment).itemId

            Intent<MainActivity>(this)
            startActivity(start)
        }
    }

}

