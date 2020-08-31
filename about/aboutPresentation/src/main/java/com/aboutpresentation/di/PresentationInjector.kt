package com.aboutpresentation.di

import com.aboutdata.di.DataInjector
import com.aboutdomain.di.DomainInjector
import com.aboutpresentation.di.DaggerPresentationComponent
import com.basepresentation.BaseApplication

internal object PresentationInjector {

    fun create()=
        DaggerPresentationComponent
            .builder()
            .domainExposer(
                DomainInjector.create(
                    DataInjector.create()
                )
            )
            .build()

}