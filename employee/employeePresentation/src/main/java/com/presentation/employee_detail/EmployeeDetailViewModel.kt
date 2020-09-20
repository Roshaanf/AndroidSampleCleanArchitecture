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
import com.basepresentation.di.scope.PresentationScope
import com.basepresentation.util.parseError
import com.presentation.EMPLOYEE_ID
import com.presentation.di.scope.EmployeeDetailScope
import javax.inject.Inject

@EmployeeDetailScope
internal class EmployeeDetailViewModel
@Inject constructor(
    private val getItemUseCase: GetEmployeeUseCase,
    val itemDetailUiModel: EmployeeDetailUiModel
) :
    BaseViewModel() {

    private val _events = MutableLiveData<BaseEvent<EmployeeDetailEvents>>()
    val events: LiveData<BaseEvent<EmployeeDetailEvents>>
        get() = _events


    fun handleIntent(bundle: Bundle?) {

        bundle?.run {
            if (containsKey(EMPLOYEE_ID)) {

                showLoader()

                viewModelScope.async {
                    when (val result = getItemUseCase(getInt(EMPLOYEE_ID))) {
                        is Result.Success -> {
                            hideLoader()
                            itemDetailUiModel.map(result.data ?: return@async)
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