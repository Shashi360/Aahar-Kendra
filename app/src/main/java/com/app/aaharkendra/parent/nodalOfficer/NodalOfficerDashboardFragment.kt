package com.app.aaharkendra.parent.nodalOfficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.FragmentCenterHeadDashboardBinding
import com.app.aaharkendra.databinding.FragmentNodalOfficerDashboardBinding
import com.app.aaharkendra.parent.centerhead.CenterHeadActivity
import com.app.aaharkendra.parent.centerhead.CenterHeadDailyMealReportFragment
import com.app.aaharkendra.parent.centerhead.CenterHeadMealDetailsFragment
import com.app.aaharkendra.parent.centerhead.CenterHeadMonthlyMealReportFragment


class NodalOfficerDashboardFragment : Fragment() {
    private var _binding: FragmentNodalOfficerDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNodalOfficerDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as NodalOfficerActivity
        activity.supportActionBar?.title = "Dashboard"

        binding.nodalDashboardTvDailyReport.setOnClickListener {
            replaceFragment(NodalDailyMealReportFragment(), "Daily Meal report")
        }

        binding.nodalDashboardTvMonthlyReport.setOnClickListener {
            replaceFragment(NodalMonthlyMealReportFragment(), "Monthly Meal report")
        }
    }
    private fun replaceFragment(fragment: Fragment, title: String) {
        val activity = activity
        if (activity != null && activity is NodalOfficerActivity) {
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