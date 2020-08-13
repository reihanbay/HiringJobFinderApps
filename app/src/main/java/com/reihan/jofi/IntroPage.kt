package com.reihan.jofi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.intro_layout.*

class IntroPage : Fragment() {

    var position = 0
    val mResources = intArrayOf(R.drawable.regis, R.drawable.hire, R.drawable.work)
    val mTitle = intArrayOf(R.string.title1, R.string.title2, R.string.title3)
    val mDesc = intArrayOf(R.string.description1, R.string.description2, R.string.description3)

    fun newInstance(position: Int): IntroPage {
        val fragment = IntroPage()
        val arguments = Bundle()
        arguments.putInt("POSITION", position)
        fragment.setArguments(arguments)
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.intro_layout, container, false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val args = arguments
        if (args != null) {
            position = args.getInt("POSITION")
        }

        introImage.setImageDrawable(resources.getDrawable(mResources[position]))
        title.setText(getString(mTitle[position]))
        description.setText(getString(mDesc[position]))

    }
}