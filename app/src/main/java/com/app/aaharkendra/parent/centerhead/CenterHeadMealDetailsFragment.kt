package com.app.aaharkendra.parent.centerhead

import android.app.DatePickerDialog
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
        binding.centerheadSendDayMealButton.setOnClickListener {
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
                    Log.d(getTAG(), "onItemSelected selectedDays : $selectedDays")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case where nothing is selected if needed
                }
            }
    }

    private fun validateInput(
        value: String,
        emptyErrorMessage: String
    ): Boolean {
        if (value.isEmpty()) {
            showToast(emptyErrorMessage)
            return false
        }
        return true
    }

    private fun sendDataFromDayMeal() {
        // Retrieve data from the relevant views
        val selectedDate = binding.dayMealDatePicker.text.toString().trim()
        val selectedDay = selectedDays
        val selectedModeOfMeal = binding.centerheadDashboardDaySpinner.selectedItem.toString()
        val mealConsumed = binding.mealConsumedEditText.text.toString().trim()
        val mealLeftOver = binding.mealLeftOverEditText.text.toString().trim()

        Log.d(getTAG(), "Selected Date: $selectedDate")
        Log.d(getTAG(), "Selected Day: $selectedDay")
        Log.d(getTAG(), "Mode of Meal: $selectedModeOfMeal")
        Log.d(getTAG(), "Meal Consumed: $mealConsumed")
        Log.d(getTAG(), "Meal Left Over: $mealLeftOver")

        // Perform validation checks
        if (!validateInput(selectedDay, "Please select a day.") ||
            !validateInput(selectedModeOfMeal, "Please select a mode of meal.") ||
            !validateInput(mealConsumed, "Please enter the meal consumed value.") ||
            !validateInput(mealLeftOver, "Please enter the left-over meal value.")
        ) {
            return
        }

        // Reset input fields
        binding.dayMealDatePicker.text = resources.getString(R.string.select_date)
        binding.centerheadDashboardDaySpinner.setSelection(0)
        binding.mealConsumedEditText.text = null
        binding.mealLeftOverEditText.text = null

        showToast("Data sent successfully!")
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

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getTAG(): String {
            return CenterHeadMealDetailsFragment::class.java.simpleName
        }
    }
}
