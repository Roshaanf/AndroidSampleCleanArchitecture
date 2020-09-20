package com.presentation.employees.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.entity.EmployeeEntity
import com.presentation.databinding.LiEmployeeBinding
import com.presentation.di.scope.EmployeesScope
import javax.inject.Inject

@EmployeesScope
internal class EmployeesAdapter
@Inject constructor(private val eventHandler: EventHandler) :
    RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {

    private val list = mutableListOf<EmployeeEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LiEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list.get(position))
    }

    fun addItems(list: List<EmployeeEntity>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: LiEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(employeeEntity: EmployeeEntity) {

            binding.name.text = employeeEntity.name

            binding.root.setOnClickListener {
                eventHandler.onEmployeeClicked(employeeEntity)
            }
        }

    }

    internal interface EventHandler {
        fun onEmployeeClicked(employeeEntity: EmployeeEntity)
    }
}