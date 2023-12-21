package com.app.aaharkendra.parent.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.ActivityAdminBinding
import com.app.aaharkendra.databinding.ActivityLoginBinding

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}