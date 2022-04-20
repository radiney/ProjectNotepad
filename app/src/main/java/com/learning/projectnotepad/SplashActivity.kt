package com.learning.projectnotepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView : ImageView = findViewById(R.id.imageView)

        imageView.alpha = 0f
        imageView.animate().setDuration(2000).alpha(1f).withEndAction{
            val mainIntent = Intent (this , MainActivity::class.java)
            startActivity(mainIntent)

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}