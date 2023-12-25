package com.app.aaharkendra.parent.centerhead

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.aaharkendra.databinding.CenterheadItemDayMealReportBinding
import com.app.aaharkendra.databinding.CenterheadItemMonthlyMealReportBinding

class CenterHeadMonthlyMealReportAdapter(private val dataList: List<CenterHeadMonthlyMealReportItem>) :
    RecyclerView.Adapter<CenterHeadMonthlyMealReportAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CenterheadItemMonthlyMealReportBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CenterHeadMonthlyMealReportItem) {
            binding.centerHeadItemMonthlySerial.text = "SL No: ${item.serialNo}"
            binding.centerHeadItemMonthlyDate.text = "Date: ${item.date}"
            binding.centerHeadItemMonthlyDay.text = "Day: ${item.day}"
            binding.centerHeadItemMonthlyMealIndent.text = "Meal Indent: ${item.mealIndent}"
            binding.centerHeadItemMonthlyMealConsumption.text = "Meal Consumption: ${item.mealConsumption}"
            binding.centerHeadItemMonthlyMealLeft.text = "Left Over Meal: ${item.leftOverMeal}"
            binding.centerHeadItemMonthlyShift.text = "Shift: ${item.shift}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CenterheadItemMonthlyMealReportBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
