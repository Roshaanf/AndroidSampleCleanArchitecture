package com.presentation.di

import com.basepresentation.BaseApplication
import com.data.di.DataInjector
import com.domain.di.DomainInjector
import com.presentation.di.component.DaggerPresentationComponent
import com.presentation.di.component.PresentationComponent

internal object PresentationInjector {

    private val presentationComponent: PresentationComponent
            by lazy {
                DaggerPresentationComponent
                    .builder()
                    .basePresentationComponent(BaseApplication.basePresentationComponent)
                    .domainExposer(
                        DomainInjector.create(
                            DataInjector.create()
                        )
                    )
                    .build()
            }


    fun buildEmployeesComponent() =
        presentationComponent
            .provideEmployeesComponent()
            .create()


    fun buildEmployeeDetailComponent() =
        presentationComponent
            .provideEmployeeDetailComponent()
            .create()

}