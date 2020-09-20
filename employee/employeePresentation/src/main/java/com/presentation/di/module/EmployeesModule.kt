package com.presentation.di.module

import com.presentation.employees.EmployeesViewModel
import com.presentation.employees.adapter.EmployeesAdapter
import dagger.Binds
import dagger.Module

@Module
internal abstract class EmployeesModule {

    @Binds
    abstract fun bindEmployeesAdapterHandler(viewmodel: EmployeesViewModel): EmployeesAdapter.EventHandler
}