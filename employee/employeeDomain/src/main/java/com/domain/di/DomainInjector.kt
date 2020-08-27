package com.domain.di

import com.domain.di.expose.DomainExposer
import com.domain.di.require.DataProvider

object DomainInjector {

    lateinit var domainExposer: DomainExposer

    fun create(dataProvider: DataProvider): DomainExposer {
        domainExposer =
            DaggerDomainComponent
                .builder()
                .dataProvider(dataProvider)
                .build()

        return domainExposer
    }
}