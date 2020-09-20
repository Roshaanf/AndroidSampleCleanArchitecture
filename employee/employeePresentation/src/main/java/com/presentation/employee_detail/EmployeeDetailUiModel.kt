package com.presentation.employee_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.basepresentation.di.scope.PresentationScope
import com.domain.entity.EmployeeEntity
import com.presentation.di.scope.EmployeeDetailScope
import javax.inject.Inject

@EmployeeDetailScope
internal class EmployeeDetailUiModel
@Inject constructor() {

    private val _title: MutableLiveData<String> = MutableLiveData()
    val title: LiveData<String>
        get() = _title

    fun map(itemDetail: EmployeeEntity) {
        println("name ${itemDetail.name}")
        _title.value = itemDetail.name
    }
}