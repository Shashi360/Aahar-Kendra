package com.app.aaharkendra.parent.nodalOfficer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.aaharkendra.databinding.NodalItemMonthlyMealReportBinding

class NodalMonthlyMealReportAdapter(private val dataList: List<NodalMonthlyMealReportItem>) :
    RecyclerView.Adapter<NodalMonthlyMealReportAdapter.ViewHolder>() {

    class ViewHolder(private val binding: NodalItemMonthlyMealReportBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NodalMonthlyMealReportItem) {
            binding.nodalItemMonthlySerial.text = "SL No: ${item.serialNo}"
            binding.nodalItemMonthlyDate.text = "Date: ${item.date}"
            binding.nodalItemMonthlyDay.text = "Day: ${item.day}"
            binding.nodalItemMonthlyMealIndent.text = "Meal Indent: ${item.mealIndent}"
            binding.nodalItemMonthlyMealConsumption.text =
                "Meal Consumption: ${item.mealConsumption}"
            binding.nodalItemMonthlyMealLeft.text = "Left Over Meal: ${item.leftOverMeal}"
            binding.nodalItemMonthlyShift.text = "Shift: ${item.shift}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NodalItemMonthlyMealReportBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
