package com.avanza.aboutdomain.di

import com.avanza.aboutdomain.di.expose.DomainExposer
import com.avanza.aboutdomain.di.require.DataRequire

object DomainInjector {

//    this variable is for future use if any other screen within feature require same
//    dep thn dont need to build  again
    lateinit var domainExposer: DomainExposer

    fun create(dataProvider: DataRequire): DomainExposer {
        domainExposer =
            DaggerDomainComponent
                .builder()
                .dataRequire(dataProvider)
                .build()

        return domainExposer
    }
}