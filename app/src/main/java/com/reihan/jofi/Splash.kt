package com.reihan.jofi

import android.os.Bundle
import android.os.Handler

class Splash : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
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
