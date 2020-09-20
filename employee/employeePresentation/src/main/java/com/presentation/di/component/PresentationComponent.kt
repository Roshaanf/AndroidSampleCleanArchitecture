package com.presentation.di.component

import com.basepresentation.di.BasePresentationComponent
import com.basepresentation.di.scope.PresentationScope
import com.domain.di.expose.DomainExposer
import com.presentation.employee_detail.EmployeeDetail

import dagger.Component

@PresentationScope
@Component(
    dependencies = [BasePresentationComponent::class,
        DomainExposer::class]
)
internal interface PresentationComponent {


    fun provideEmployeesComponent(): EmployeesComponent.Factory
    fun provideEmployeeDetailComponent(): EmployeeDetailComponent.Factory


}