package com.reihan.jofi

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.reihan.jofi.databinding.ActivityMainBinding
import com.reihan.jofi.databinding.ContainerDialogLogoutBinding
import com.reihan.jofi.fragment.HomeFragment
import com.reihan.jofi.fragment.OffersFragment
import com.reihan.jofi.fragment.ProjectFragment
import com.reihan.jofi.utils.sharedpreferences.PreferenceHelper

class MainActivity : BaseActivity(){

    private lateinit var binding : ActivityMainBinding
    lateinit var sharedPref : PreferenceHelper

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())

        val Home = HomeFragment()
        val Offer = OffersFragment()
        val Project = ProjectFragment()
        val Profile = ProfileScreen()

        currentNavigation(Home)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_homeFragment -> currentNavigation(Home)
                R.id.ic_offersFragment -> currentNavigation(Offer)
                R.id.ic_projectFragment -> currentNavigation(Project)
                R.id.ic_profileFragment -> currentNavigation(Profile)
                else -> false
            }
        }
    }

    fun currentNavigation(fragment: Fragment):Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction().apply {
               replace(R.id.container, fragment)
                   .commit()
            }
            return true
        }
        return false
    }


}