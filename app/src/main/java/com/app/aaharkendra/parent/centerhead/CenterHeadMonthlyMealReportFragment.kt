package com.app.aaharkendra.parent.centerhead

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.FragmentCenterHeadMonthlyMealReportBinding

class CenterHeadMonthlyMealReportFragment : Fragment() {
    private var _binding: FragmentCenterHeadMonthlyMealReportBinding? = null
    private val binding get() = _binding!!
    private var selectedYear: String = ""
    private var selectedMonth: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCenterHeadMonthlyMealReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            CenterHeadMonthlyMealReportItem("1", "2023-01-01", "Monday", "Breakfast", "100", "10", "Morning"),
            CenterHeadMonthlyMealReportItem("2", "2023-01-02", "Tuesday", "lunch", "50", "20", "Afternoon"),
            CenterHeadMonthlyMealReportItem("3", "2023-01-03", "Wed", "Breakfast", "40", "30", "Morning"),
            CenterHeadMonthlyMealReportItem("4", "2023-01-04", "Thursday", "lunch", "30", "0", "Morning"),
            CenterHeadMonthlyMealReportItem("5", "2023-01-05", "Friday", "Breakfast", "90", "40", "Afternoon"),
            // Add more items as needed
        )

        val adapter = CenterHeadMonthlyMealReportAdapter(items)
        binding.rvCenterHeadMonthlyMealReport.adapter = adapter
        binding.rvCenterHeadMonthlyMealReport.layoutManager = LinearLayoutManager(requireContext())

        val years = resources.getStringArray(R.array.years)
        val yearAdapter = ArrayAdapter(requireContext(), R.layout.custom_spinner_layout, years)
        binding.centerheadFilterSpinnerYear.adapter = yearAdapter
        binding.centerheadFilterSpinnerYear.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedYear = parent?.getItemAtPosition(position).toString()
                    Log.d(ContentValues.TAG, "onItemSelected selectedYear : $selectedYear")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case where nothing is selected if needed
                }
            }

        val months = resources.getStringArray(R.array.months)
        val monthAdapter = ArrayAdapter(requireContext(), R.layout.custom_spinner_layout, months)
        binding.centerheadFilterSpinnerMonth.adapter = monthAdapter
        binding.centerheadFilterSpinnerMonth.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedMonth = parent?.getItemAtPosition(position).toString()
                    Log.d(getTAG(), "onItemSelected selectedMonth: $selectedMonth")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case where nothing is selected if needed
                }
            }
        binding.centerheadFilterShowBtn.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Selected year $selectedYear and $selectedMonth.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        fun getTAG(): String {
            return CenterHeadMonthlyMealReportFragment::class.java.simpleName
        }
    }
}