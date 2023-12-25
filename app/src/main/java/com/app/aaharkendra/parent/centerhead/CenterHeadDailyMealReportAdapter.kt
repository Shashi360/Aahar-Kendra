package com.app.aaharkendra.parent.centerhead

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.aaharkendra.databinding.CenterheadItemDayMealReportBinding

class CenterHeadDailyMealReportAdapter(private val dataList: List<CenterHeadDailyMealReportItem>) :
    RecyclerView.Adapter<CenterHeadDailyMealReportAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CenterheadItemDayMealReportBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CenterHeadDailyMealReportItem) {
            binding.centerHeadItemSerial.text = "SL No: ${item.serialNo}"
            binding.centerHeadItemDate.text = "Date: ${item.date}"
            binding.centerHeadItemDay.text = "Day: ${item.day}"
            binding.centerHeadItemMealIndent.text = "Meal Indent: ${item.mealIndent}"
            binding.centerHeadItemMealConsumption.text = "Meal Consumption: ${item.mealConsumption}"
            binding.centerHeadItemMealLeftover.text = "Left Over Meal: ${item.leftOverMeal}"
            binding.centerHeadItemShift.text = "Shift: ${item.shift}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CenterheadItemDayMealReportBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
