package com.app.aaharkendra.parent.nodalOfficer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.aaharkendra.databinding.ActivityNodalOfficerBinding

class NodalOfficerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNodalOfficerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNodalOfficerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}