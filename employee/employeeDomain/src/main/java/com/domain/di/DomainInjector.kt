package com.domain.di

import com.domain.di.expose.DomainExposer
import com.domain.di.require.DataRequire

object DomainInjector {

//    this variable is for future use if any other screen within feature require same
//    dep thn dont need to build  again
    lateinit var domainExposer: DomainExposer
    private set

    fun create(dataProvider: DataRequire): DomainExposer {
        domainExposer =
            DaggerDomainComponent
                .builder()
                .dataRequire(dataProvider)
                .build()

        return domainExposer
    }
}