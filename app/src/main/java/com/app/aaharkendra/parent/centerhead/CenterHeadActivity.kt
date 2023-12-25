package com.app.aaharkendra.parent.centerhead

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.ActivityCenterHeadBinding

class CenterHeadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCenterHeadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCenterHeadBinding.inflate(layoutInflater)
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
        supportActionBar?.title = getString(R.string.centerhead_dashboard)
        toggle.syncState()

        // Set the default fragment when the activity is created
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, CenterHeadDashboardFragment())
                .commit()
            supportActionBar?.title = getString(R.string.centerhead_dashboard)
        }

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_dashboard -> replaceFragmentAndSetTitle(
                    CenterHeadDashboardFragment(),
                    R.string.centerhead_dashboard
                )
                R.id.menu_meal_details -> replaceFragmentAndSetTitle(
                    CenterHeadMealDetailsFragment(),
                    R.string.centerhead_meal_details
                )
                R.id.daily_meal_report -> replaceFragmentAndSetTitle(
                    CenterHeadDailyMealReportFragment(),
                    R.string.centerhead_daily_meal_report
                )
                R.id.monthly_meal_report -> replaceFragmentAndSetTitle(
                    CenterHeadMonthlyMealReportFragment(),
                    R.string.centerhead_monthly_meal_report
                )
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

    // override the onBackPressed() function to close the Drawer when the back button is clicked
    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}