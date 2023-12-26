package com.app.aaharkendra.parent.nodalOfficer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.aaharkendra.databinding.NodalItemDailyMealReportBinding

class NodalDailyMealReportAdapter(private val dataList: List<NodalDailyMealReportItem>) :
    RecyclerView.Adapter<NodalDailyMealReportAdapter.ViewHolder>() {

    class ViewHolder(private val binding: NodalItemDailyMealReportBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NodalDailyMealReportItem) {
            binding.nodalItemSerial.text = "SL No: ${item.serialNo}"
            binding.nodalItemDate.text = "Date: ${item.date}"
            binding.nodalItemDay.text = "Day: ${item.day}"
            binding.nodalItemMealIndent.text = "Meal Indent: ${item.mealIndent}"
            binding.nodalItemMealConsumption.text = "Meal Consumption: ${item.mealConsumption}"
            binding.nodalItemMealLeftover.text = "Left Over Meal: ${item.leftOverMeal}"
            binding.nodalItemShift.text = "Shift: ${item.shift}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NodalItemDailyMealReportBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
