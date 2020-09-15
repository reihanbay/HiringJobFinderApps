package com.reihan.jofi

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.reihan.jofi.databinding.ActivityProfileScreenBinding
import com.reihan.jofi.databinding.ContainerDialogLogoutBinding
import com.reihan.jofi.utils.sharedpreferences.PreferenceHelper
import com.reihan.jofi.webview.WebPortoActivity


class ProfileScreen : Fragment() {

    private lateinit var binding: ActivityProfileScreenBinding
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawer : DrawerLayout

    lateinit var sharedPref : PreferenceHelper

    companion object {
        const val Username = "Username"
        const val Expertise = "Expertise"
        const val Birth = "Birth"
        const val Summary = "Summary"
        const val Skill = "Skill"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.activity_profile_screen,
            container,
            false
        )


        binding.btnCheckPortofolio.setOnClickListener {
            val intent = Intent(activity, WebPortoActivity::class.java)
            startActivity(intent)
        }

        val toolbar = binding.toolbarMain
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        drawer = binding.drawerLayout

        val supportActionbar = (activity as AppCompatActivity).supportActionBar

        supportActionbar?.setDisplayHomeAsUpEnabled(false)
        supportActionbar?.setDisplayShowTitleEnabled(false)
        supportActionbar?.setHomeButtonEnabled(true)

        binding.drawerView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_help -> Toast.makeText((activity as AppCompatActivity).applicationContext, "Toast Help", Toast.LENGTH_LONG).show()
                R.id.menu_settings -> Toast.makeText((activity as AppCompatActivity).applicationContext, "Toast Setting", Toast.LENGTH_LONG).show()
                R.id.menu_info -> Toast.makeText((activity as AppCompatActivity).applicationContext, "Toast Info", Toast.LENGTH_LONG).show()
                R.id.menu_logout -> logoutDialog()
            }
            true
        }
        setHasOptionsMenu(true);
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.item_ic_burger, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.closeDrawer(Gravity.RIGHT);
            } else {
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        var tvUsername = arguments?.getString(Username, "Reihan")
//        var tvExpertise = arguments?.getString(Expertise, "")
//        var tvBirth = arguments?.getString(Birth, "")
//        var tvSummary = arguments?.getString(Summary, "")
//        var tvSkill = arguments?.getString(Skill, "")

//        binding.tvUsernameProfile.text = tvUsername

    }

    fun logoutDialog(){
        sharedPref = PreferenceHelper((activity as AppCompatActivity))
        val rootview = DataBindingUtil.inflate<ContainerDialogLogoutBinding>(layoutInflater, R.layout.container_dialog_logout, null,false)
        val dialog = AlertDialog.Builder((activity as AppCompatActivity))
            .setView(rootview.root)
            .setCancelable(true)
            .create()
        dialog.show()
        rootview.btnLogoutOk.setOnClickListener {
            sharedPref.clear()
            Toast.makeText((activity as AppCompatActivity).applicationContext,"Wow Keluar", Toast.LENGTH_SHORT).show()
            val intent = Intent((activity as AppCompatActivity).application, Login::class.java)
            startActivity(intent)
        }
        rootview.btnLogoutNo.setOnClickListener { dialog.dismiss() }
    }
}

