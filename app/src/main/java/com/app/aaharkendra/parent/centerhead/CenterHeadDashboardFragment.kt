import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.aaharkendra.databinding.FragmentCenterHeadDashboardBinding
import java.text.SimpleDateFormat
import java.util.Calendar


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

        binding.dayMealDatePicker.setOnClickListener {
            showDatePicker()
        }
        binding.sendButton.setOnClickListener {
            sendDataFromDayMeal()
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
