package com.app.aaharkendra.parent.centerhead

import CenterHeadDashboardFragment
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
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

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_dashboard -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, CenterHeadDashboardFragment())
                        .commit()
                    supportActionBar?.title = getString(R.string.centerhead_dashboard)
                    binding.drawerLayout.closeDrawers()
                    return@setNavigationItemSelectedListener true
                }

                R.id.menu_meal_details -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, CenterHeadMealDetailsFragment())
                        .commit()
                    supportActionBar?.title = getString(R.string.centerhead_meal_details)
                    binding.drawerLayout.closeDrawers()
                    return@setNavigationItemSelectedListener true
                }

                else -> return@setNavigationItemSelectedListener false
            }
        }
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