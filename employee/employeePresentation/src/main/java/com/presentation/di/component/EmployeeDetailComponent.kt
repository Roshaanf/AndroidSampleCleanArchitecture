package com.presentation.di.component

import com.presentation.di.scope.EmployeeDetailScope
import com.presentation.employee_detail.EmployeeDetail
import dagger.Component
import dagger.Subcomponent

@EmployeeDetailScope
@Subcomponent
internal interface EmployeeDetailComponent{
    fun inject(employeeDetail: EmployeeDetail)

    @Subcomponent.Factory
    interface Factory {
        fun create(): EmployeeDetailComponent
    }
}