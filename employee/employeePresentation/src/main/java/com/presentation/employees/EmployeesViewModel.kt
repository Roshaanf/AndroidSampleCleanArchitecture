package com.presentation.employees

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.basedomain.Result
import com.basepresentation.base.BaseEvent
import com.basepresentation.base.BaseViewModel
import com.basepresentation.util.parseError
import com.domain.entity.EmployeeEntity
import com.domain.usecase.GetEmployeesUseCase
import com.presentation.di.scope.EmployeesScope
import com.presentation.employees.adapter.EmployeesAdapter
import kotlinx.coroutines.async
import javax.inject.Inject


@EmployeesScope
internal class EmployeesViewModel @Inject constructor(
    private val getEmployeesUseCase: GetEmployeesUseCase
) : BaseViewModel(), EmployeesAdapter.EventHandler {


    private val _events = MutableLiveData<BaseEvent<EmployeesEvents>>()
    val events: LiveData<BaseEvent<EmployeesEvents>>
        get() = _events

    init {
        showLoader()

        viewModelScope.async {
            when (val result = getEmployeesUseCase()) {
                is Result.Success -> {
                    hideLoader()
                    _events.value = BaseEvent(EmployeesEvents.EMPLOYEES_FETCHED(result.data!!))
                }
                is Result.Error -> {
                    showError(parseError(result.exception))
                }
            }
        }

    }

    override fun onEmployeeClicked(employeeEntity: EmployeeEntity) {
        _events.value = BaseEvent(EmployeesEvents.OPEN_EMPLOYEE_DETAIL(employeeEntity.id ?: 0))
    }

}