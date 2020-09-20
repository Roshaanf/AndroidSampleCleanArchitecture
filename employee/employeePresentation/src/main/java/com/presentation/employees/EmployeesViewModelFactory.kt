package com.presentation.employees

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.presentation.di.scope.EmployeesScope
import javax.inject.Inject

@EmployeesScope
internal class EmployeesViewModelFactory @Inject constructor(val viewModel: EmployeesViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != EmployeesViewModel::class.java)
            throw IllegalArgumentException("Unknown View model class")
        else
            return viewModel as T
    }
}