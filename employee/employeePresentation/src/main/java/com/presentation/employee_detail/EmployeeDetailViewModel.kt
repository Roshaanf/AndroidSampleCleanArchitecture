package com.presentation.employee_detail

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.domain.usecase.GetEmployeeUseCase
import kotlinx.coroutines.async
import com.basedomain.Result
import com.basepresentation.base.BaseEvent
import com.basepresentation.base.BaseViewModel
import com.basepresentation.util.parseError
import com.domain.entity.EmployeeEntity
import com.presentation.EMPLOYEE_ID
import com.presentation.di.scope.EmployeeDetailScope
import com.presentation.mapper.transform
import com.presentation.model.Employee
import javax.inject.Inject

@EmployeeDetailScope
internal class EmployeeDetailViewModel
@Inject constructor(
    private val getItemUseCase: GetEmployeeUseCase,
    bundle: Bundle?
) :
    BaseViewModel() {

    private val _employee = MutableLiveData<Employee>()
    val employee: LiveData<Employee>
        get() = _employee

    init {
        getEmployee(bundle)
    }

    fun getEmployee(bundle: Bundle?) {

        bundle?.run {
            if (containsKey(EMPLOYEE_ID)) {

                showLoader()

                viewModelScope.async {
                    when (val result = getItemUseCase(getInt(EMPLOYEE_ID))) {
                        is Result.Success -> {
                            hideLoader()

                            _employee.value = transform(result.data!!)
                        }
                        is Result.Error -> {
                            showError(parseError(result.exception))
                        }
                    }
                }
            }
        }
    }


}