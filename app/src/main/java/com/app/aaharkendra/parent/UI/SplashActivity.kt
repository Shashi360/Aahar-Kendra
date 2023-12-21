package com.app.aaharkendra.parent.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.app.aaharkendra.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            checkLoginStatus()
        }, 2000)
    }

    private fun checkLoginStatus() {
        val isLoggedIn = isLoggedIn()

        // Navigate to the appropriate activity based on the login status
        if (isLoggedIn) {
            navigateToMainActivity()
        } else {
            navigateToLoginActivity()
        }
    }

    private fun isLoggedIn(): Boolean {
        // Replace this with your actual logic to check if the user is logged in
        // For example, you can check SharedPreferences, database, etc.
        // Return true if logged in, false otherwise
        return false
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
