package com.app.aaharkendra.parent.centerhead

import android.app.DatePickerDialog
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.app.aaharkendra.R
import com.app.aaharkendra.databinding.FragmentCenterHeadMealDetailsBinding
import java.text.SimpleDateFormat
import java.util.Calendar


class CenterHeadMealDetailsFragment : Fragment() {

    private var _binding: FragmentCenterHeadMealDetailsBinding? = null
    private val binding get() = _binding!!
    private var selectedDays: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCenterHeadMealDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dayMealDatePicker.setOnClickListener {
            showDatePicker()
        }
        binding.sendDayMealButton.setOnClickListener {
            sendDataFromDayMeal()
        }
        val days = resources.getStringArray(R.array.days)
        val daysAdapter = ArrayAdapter(requireContext(), R.layout.custom_spinner_layout, days)
        binding.centerheadDashboardDaySpinner.adapter = daysAdapter
        binding.centerheadDashboardDaySpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedDays = parent?.getItemAtPosition(position).toString()
                    Log.d(ContentValues.TAG, "onItemSelected selectedDays : $selectedDays")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case where nothing is selected if needed
                }
            }
    }

    private fun sendDataFromDayMeal() {
        // Retrieve data from the relevant views
        val selectedDate = binding.dayMealDatePicker.text.toString().trim()
        val selectedDay = ""
        val selectedModeOfMeal = ""
        val mealConsumed = ""
        val mealLeftOver = ""

        Log.d("DayMealData", "Selected Date: $selectedDate")
        Log.d("DayMealData", "Selected Day: $selectedDay")
        Log.d("DayMealData", "Mode of Meal: $selectedModeOfMeal")
        Log.d("DayMealData", "Meal Consumed: $mealConsumed")
        Log.d("DayMealData", "Meal Left Over: $mealLeftOver")
    }


    private fun showDatePicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            requireContext(), { view, year, monthOfYear, dayOfMonth ->
                val c1 = Calendar.getInstance()
                c1.set(year, monthOfYear, dayOfMonth);
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
                val strDate = simpleDateFormat.format(c1.time)
                binding.dayMealDatePicker.text = strDate
            }, year, month, day
        )
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        // Your companion object, if needed
    }
}
