package com.presentation.di.component

import com.presentation.di.module.EmployeesModule
import com.presentation.di.scope.EmployeesScope
import com.presentation.employees.EmployeesFragment
import dagger.Component
import dagger.Subcomponent

@EmployeesScope
@Subcomponent(modules = [EmployeesModule::class])
internal interface EmployeesComponent {
    fun inject(employeesFragment: EmployeesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): EmployeesComponent
    }
}