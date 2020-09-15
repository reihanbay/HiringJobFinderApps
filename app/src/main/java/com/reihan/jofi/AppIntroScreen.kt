package com.reihan.jofi

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.reihan.jofi.databinding.ActivityOnBoardBinding
import com.reihan.jofi.utils.sharedpreferences.Constants
import com.reihan.jofi.utils.sharedpreferences.PreferenceHelper
import kotlinx.android.synthetic.main.activity_on_board.*

class AppIntroScreen : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOnBoardBinding
    lateinit var sharedPref: PreferenceHelper
    val mResources = intArrayOf(R.drawable.regis, R.drawable.hire, R.drawable.work)
    lateinit var adapter: SlidingPagerAdapter
    var currentTab = 0
    var remove = 0
    var tabCount = 0

    override fun layoutId(): Int {
        return R.layout.activity_on_board
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())

        tabCount = mResources.size
        adapter = SlidingPagerAdapter(supportFragmentManager, mResources)
        viewPager.adapter = adapter


        val pageTransformer = ParallaxTransformer()
        viewPager.setPageTransformer(true, pageTransformer)


        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

        })
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                currentTab = position + 1
                remove = position - 1

                if (currentTab == tabCount) {
                    next.text = getString(R.string.start)
                } else {
                    next.text = getString(R.string.next)
                }
                if (currentTab == 1 ){
                    skip.text = getString(R.string.skip)
                } else {
                    skip.text = getString(R.string.back)
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })
        next.setOnClickListener(this)
        skip.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next -> {
                if (currentTab == tabCount) {
                    next.text = getString(R.string.start)
                    Intent<Login>(this)
                    startActivity(start)
                    Toast.makeText(this@AppIntroScreen, getString(R.string.skip_pressed), Toast.LENGTH_SHORT).show()
                    // Proceed to Main/Home Activity of the App
                } else {
                    next.text = getString(R.string.next)
                    viewPager.currentItem = currentTab
                }
            }

            R.id.skip -> {
                if(currentTab != 1 ){
                    skip.text = getString(R.string.back)
                    viewPager.currentItem = remove
                } else {
                    skip.text = getString(R.string.skip)
                    Intent<Login>(this)
                    startActivity(start)
                    Toast.makeText(this@AppIntroScreen, getString(R.string.skip_pressed), Toast.LENGTH_SHORT).show()
                    // Proceed to Main/Home Activity of the App
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        sharedPref = PreferenceHelper(this)
        if(sharedPref.getBoolean(Constants.PREF_IS_LOGIN)==true){
            IntentStart<MainActivity>(this)
        }
    }
}

class SlidingPagerAdapter(fragmentManager: FragmentManager?, val mResources: IntArray) : FragmentPagerAdapter(
    fragmentManager!!
) {

    override fun getItem(position: Int): Fragment {
        return IntroPage().newInstance(position)
    }

    override fun getCount(): Int {
        return mResources.size
    }
}
