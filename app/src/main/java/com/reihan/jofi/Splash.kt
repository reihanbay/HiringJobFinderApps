package com.reihan.jofi

import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.reihan.jofi.databinding.ActivitySplashBinding

class Splash : BaseActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())
        val time = 4000

        Handler().postDelayed(Runnable { //setelah loading maka akan langsung berpindah ke home activity
            Intent<AppIntroScreen>(this)
            startActivity(start)
            finish()
        }, time.toLong())
    }
    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

}
