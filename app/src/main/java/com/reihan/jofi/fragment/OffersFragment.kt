package com.reihan.jofi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.reihan.jofi.R
import com.reihan.jofi.databinding.FragmentOffersBinding

class OffersFragment : Fragment() {

    private lateinit var binding : FragmentOffersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_offers, container, false)

        return binding.root
    }
}