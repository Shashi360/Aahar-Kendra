package com.app.aaharkendra.parent.centerhead

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.FragmentCenterHeadDashboardBinding


class CenterHeadDashboardFragment : Fragment() {
    private var _binding: FragmentCenterHeadDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCenterHeadDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as CenterHeadActivity
        activity.supportActionBar?.title = "Dashboard"

        binding.centerHeadDashboardTvMealEntry.setOnClickListener {
            replaceFragment(CenterHeadMealDetailsFragment(), "Meal Details")
        }

        binding.centerHeadDashboardTvDailyReport.setOnClickListener {
            replaceFragment(CenterHeadDailyMealReportFragment(), "Daily Meal Report")
        }

        binding.centerHeadDashboardTvMonthlyReport.setOnClickListener {
            replaceFragment(CenterHeadMonthlyMealReportFragment(), "Monthly Meal Report")
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        val activity = activity
        if (activity != null && activity is CenterHeadActivity) {
            val transaction = activity.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

            // Check if the activity has a support action bar
            activity.supportActionBar?.title = title
        }
    }

    companion object {

    }
}