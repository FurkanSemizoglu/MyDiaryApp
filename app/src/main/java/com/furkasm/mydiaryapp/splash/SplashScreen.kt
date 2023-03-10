package com.furkasm.mydiaryapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.furkasm.mydiaryapp.R
import com.furkasm.mydiaryapp.activities.MainActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            val intent = Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}