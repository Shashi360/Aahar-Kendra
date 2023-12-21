package com.app.aaharkendra.parent.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.ActivityLoginBinding
import com.app.aaharkendra.parent.admin.AdminActivity
import com.app.aaharkendra.parent.centerhead.CenterHeadActivity
import com.app.aaharkendra.parent.nodalOfficer.NodalOfficerActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var selectedDesignation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val designations = resources.getStringArray(R.array.designations)

        val adapter =
            ArrayAdapter(this, R.layout.custom_spinner_layout, designations)
        binding.designationSpinner.adapter = adapter

        binding.designationSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedDesignation = parent?.getItemAtPosition(position).toString()
                    Log.d(TAG, "onItemSelected: $selectedDesignation")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case where nothing is selected if needed
                }
            }

        binding.loginButton.setOnClickListener {
            selectedDesignation = binding.designationSpinner.selectedItem.toString().trim()
            val centerId = binding.centerIdEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (selectedDesignation == "- Choose Designation -") {
                // Show an error message or handle the case where no designation is selected
                showToast("Please select a valid designation")
            } else {
                when (selectedDesignation) {
                    "Admin" -> loginAdmin(centerId, password)
                    "Center Head" -> loginCenterHead(centerId, password)
                    "Nodal Officer" -> loginNodalOfficer(centerId, password)
                }
            }
        }
    }

    private fun loginAdmin(centerId: String, password: String) {
        if (centerId == "Admin" && password == "123") {
            showToast("Admin Login Successful")
            startActivityAndFinish(AdminActivity::class.java)
        } else {
            showToast("Invalid credentials for Admin")
        }
    }

    private fun loginCenterHead(centerId: String, password: String) {
//        val validCenterId = "KHO/MUN/BHU/JAYDEVVIHAR"
        val validCenterId = "head"
        if (centerId == validCenterId && password == "123") {
            showToast("Center Head Login Successful")
            startActivityAndFinish(CenterHeadActivity::class.java)
        } else {
            showToast("Invalid credentials for Center Head")
        }
    }

    private fun loginNodalOfficer(centerId: String, password: String) {
//        val validCenterId = "KHO/MUN/BHU/JAYDEVVIHAR"
        val validCenterId = "officer"
        if (centerId == validCenterId && password == "123") {
            showToast("Nodal Officer Login Successful")
            startActivityAndFinish(NodalOfficerActivity::class.java)
        } else {
            showToast("Invalid credentials for Nodal Officer")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun <T : AppCompatActivity> startActivityAndFinish(activityClass: Class<T>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
    }
}
