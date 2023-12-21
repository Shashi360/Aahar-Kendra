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
        // Create ArrayAdapter for years and set it to the yearSpinner
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

        // Create ArrayAdapter for months and set it to the monthSpinner
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
                    Log.d(ContentValues.TAG, "onItemSelected selectedMonth: $selectedMonth")
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

    }
}