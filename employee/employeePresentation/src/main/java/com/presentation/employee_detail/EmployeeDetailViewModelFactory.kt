package com.presentation.employee_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basepresentation.di.scope.PresentationScope
import com.presentation.di.scope.EmployeeDetailScope
import javax.inject.Inject

@EmployeeDetailScope
internal class EmployeeDetailViewModelFactory @Inject constructor(val viewModel: EmployeeDetailViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != EmployeeDetailViewModel::class.java)
            throw IllegalArgumentException("Unknown View model class")
        else
            return viewModel as T
    }
}