package com.reihan.jofi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reihan.jofi.R
import com.reihan.jofi.databinding.FragmentProjectBinding
import com.reihan.jofi.recyclerview.RecyclerProjectAdapter

class ProjectFragment : Fragment() {
    private lateinit var binding : FragmentProjectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project, container, false)

        binding.recycleView.adapter = RecyclerProjectAdapter()
        binding.recycleView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        return binding.root
    }
}