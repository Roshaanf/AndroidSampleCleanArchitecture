package com.avanza.aboutpresentation.di

import com.avanza.aboutdata.di.DataInjector
import com.avanza.aboutdomain.di.DomainInjector
import com.basepresentation.BaseApplication

internal object PresentationInjector {

    fun create(){
        DaggerPresentationComponent
            .builder()
            .domainExposer(
                DomainInjector.create(
                    DataInjector.create()
                )
            )
            .build()
    }
}