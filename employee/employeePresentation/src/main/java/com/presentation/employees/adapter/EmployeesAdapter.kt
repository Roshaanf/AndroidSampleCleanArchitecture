package com.presentation.employees.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aapa.listener.recyclerview.BaseRecyclerViewBindableAdapter
import com.aapa.listener.recyclerview.BaseRecyclerViewContract
import com.presentation.R
import com.presentation.databinding.LiEmployeeBinding
import com.presentation.di.scope.EmployeesScope
import com.presentation.model.Employee
import javax.inject.Inject

@EmployeesScope
internal class EmployeesAdapter
@Inject constructor() :
    RecyclerView.Adapter<EmployeesAdapter.ViewHolder>(),
    BaseRecyclerViewBindableAdapter<EmployeesAdapter.ClickEvents, Employee> {

    private lateinit var mContract: BaseRecyclerViewContract.ClickHandler<*, *>
    private lateinit var mList: List<Employee>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.li_employee,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mList.get(position))
    }


    inner class ViewHolder(private val binding: LiEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(employee: Employee) {

            binding.model = employee
            binding.contract = mContract

        }

    }


    override fun setData(list: List<Employee>) {
        mList = list
        notifyDataSetChanged()
    }

    override fun setClickHandler(contract: BaseRecyclerViewContract.ClickHandler<ClickEvents, Employee>) {
        mContract = contract
    }

    override fun indexOf(item: Employee): Int = mList.indexOf(item)

    enum class ClickEvents {
        ITEM_CLICKED
    }


}