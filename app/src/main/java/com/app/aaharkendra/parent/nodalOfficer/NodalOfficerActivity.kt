package com.app.aaharkendra.parent.nodalOfficer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.ActivityNodalOfficerBinding
import com.app.aaharkendra.parent.centerhead.CenterHeadDailyMealReportFragment
import com.app.aaharkendra.parent.centerhead.CenterHeadMealDetailsFragment
import com.app.aaharkendra.parent.ui.LoginActivity

class NodalOfficerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNodalOfficerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNodalOfficerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.root.findViewById(R.id.toolbar))

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.root.findViewById(R.id.toolbar),
            R.string.nav_open,
            R.string.nav_close
        )

        binding.drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled = true
        supportActionBar?.title = getString(R.string.nodal_dashboard)
        toggle.syncState()

        // Set the default fragment when the activity is created
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, NodalOfficerDashboardFragment())
                .commit()
            supportActionBar?.title = getString(R.string.nodal_dashboard)
        }

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_nodal_dashboard -> replaceFragmentAndSetTitle(
                    NodalOfficerDashboardFragment(),
                    R.string.nodal_dashboard
                )

                R.id.menu_nodal_daily_meal_report -> replaceFragmentAndSetTitle(
                    NodalDailyMealReportFragment(),
                    R.string.nodal_daily_meal_details
                )

                R.id.menu_nodal_monthly_meal_report -> replaceFragmentAndSetTitle(
                    NodalMonthlyMealReportFragment(),
                    R.string.nodal_monthly_meal_details
                )

                R.id.menu_nodal_logout -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragmentAndSetTitle(fragment: Fragment, titleResId: Int): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
        supportActionBar?.title = getString(titleResId)
        binding.drawerLayout.closeDrawers()
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // override the onSupportNavigateUp() function to launch the Drawer when the hamburger icon is clicked
    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navigationView)
        return true
    }

    private fun <T : AppCompatActivity> startActivityAndFinish(activityClass: Class<T>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
    }

    // override the onBackPressed() function to close the Drawer when the back button is clicked
    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}