package com.app.aaharkendra.parent.nodalOfficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.FragmentCenterHeadDailyMealReportBinding
import com.app.aaharkendra.databinding.FragmentNodalDailyMealReportBinding
import com.app.aaharkendra.parent.centerhead.CenterHeadDailyMealReportAdapter
import com.app.aaharkendra.parent.centerhead.CenterHeadDailyMealReportItem


class NodalDailyMealReportFragment : Fragment() {
    private var _binding: FragmentNodalDailyMealReportBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NodalDailyMealReportAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNodalDailyMealReportBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = listOf(
            NodalDailyMealReportItem("1", "2023-01-01", "Monday", "Breakfast", "100", "10", "Morning"),
            NodalDailyMealReportItem("2", "2023-01-02", "Tuesday", "lunch", "50", "20", "Afternoon"),
            NodalDailyMealReportItem("3", "2023-01-03", "Wed", "Breakfast", "40", "30", "Morning"),
            NodalDailyMealReportItem("4", "2023-01-04", "Thursday", "lunch", "30", "0", "Morning"),
            NodalDailyMealReportItem("5", "2023-01-05", "Friday", "Breakfast", "90", "40", "Afternoon"),
            // Add more items as needed
        )

        adapter = NodalDailyMealReportAdapter(items)
        binding.rvNodalDailyMealReport.adapter = adapter
        binding.rvNodalDailyMealReport.layoutManager = LinearLayoutManager(requireContext())

    }
    companion object {

    }
}