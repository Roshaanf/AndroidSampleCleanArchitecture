package com.presentation.employees.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aapa.listener.recyclerview.BaseRecyclerViewBindableAdapter
import com.aapa.listener.recyclerview.BaseRecyclerViewContract
import com.domain.entity.EmployeeEntity
import com.presentation.R
import com.presentation.databinding.LiEmployeeBinding
import com.presentation.di.scope.EmployeesScope
import javax.inject.Inject

@EmployeesScope
internal class EmployeesAdapter
@Inject constructor() :
    RecyclerView.Adapter<EmployeesAdapter.ViewHolder>(),
    BaseRecyclerViewBindableAdapter<EmployeesAdapter.ClickEvents, EmployeeEntity> {

    private lateinit var mContract: BaseRecyclerViewContract.ClickHandler<*, *>
    private lateinit var mList: List<EmployeeEntity>


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

        fun setData(employeeEntity: EmployeeEntity) {

            binding.model = employeeEntity
            binding.contract = mContract

        }

    }


    override fun setData(list: List<EmployeeEntity>) {
        mList = list
        notifyDataSetChanged()
    }

    override fun setClickHandler(contract: BaseRecyclerViewContract.ClickHandler<ClickEvents, EmployeeEntity>) {
        mContract = contract
    }

    override fun indexOf(item: EmployeeEntity): Int = mList.indexOf(item)

    enum class ClickEvents {
        ITEM_CLICKED
    }


}