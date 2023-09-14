package com.odukabdulbasit.fadeinsplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashImage = findViewById<ImageView>(R.id.splashImage)
        // Create a fade-in animation
        splashImage.alpha = 0f
        splashImage.animate().alpha(1f).setDuration(FADE_IN_DURATION).start()

        // Create a handler to delay the transition to the main activity
        Handler().postDelayed({
            // Start the main activity
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMEOUT)
    }

    companion object{
        private const val SPLASH_TIMEOUT: Long = 3000 // 3 seconds
        private const val FADE_IN_DURATION: Long = 1500 // 1.5 seconds
    }
}

