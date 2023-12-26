package com.app.aaharkendra.parent.centerhead

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.aaharkendra.databinding.FragmentCenterHeadDailyMealReportBinding

class CenterHeadDailyMealReportFragment : Fragment() {
    private var _binding: FragmentCenterHeadDailyMealReportBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CenterHeadDailyMealReportAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCenterHeadDailyMealReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = listOf(
            CenterHeadDailyMealReportItem("1", "2023-01-01", "Monday", "Breakfast", "100", "10", "Morning"),
            CenterHeadDailyMealReportItem("2", "2023-01-02", "Tuesday", "lunch", "50", "20", "Afternoon"),
            CenterHeadDailyMealReportItem("3", "2023-01-03", "Wed", "Breakfast", "40", "30", "Morning"),
            CenterHeadDailyMealReportItem("4", "2023-01-04", "Thursday", "lunch", "30", "0", "Morning"),
            CenterHeadDailyMealReportItem("5", "2023-01-05", "Friday", "Breakfast", "90", "40", "Afternoon"),
            // Add more items as needed
        )

        adapter = CenterHeadDailyMealReportAdapter(items)
        binding.rvCenterHeadDailyMealReport.adapter = adapter
        binding.rvCenterHeadDailyMealReport.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {

    }
}