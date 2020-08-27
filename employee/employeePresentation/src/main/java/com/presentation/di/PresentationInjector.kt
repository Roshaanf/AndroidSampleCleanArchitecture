package com.presentation.di

import com.basepresentation.BaseApplication
import com.data.di.DataInjector
import com.domain.di.DomainInjector

internal object PresentationInjector {


    fun create() =
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