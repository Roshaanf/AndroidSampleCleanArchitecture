package com.aboutdomain.di

import com.aboutdomain.di.require.DataRequire
import com.aboutdomain.di.DaggerDomainComponent
import com.aboutdomain.di.expose.DomainExposer

object DomainInjector {

    fun create(dataProvider: DataRequire): DomainExposer =
        DaggerDomainComponent
            .builder()
            .dataRequire(dataProvider)
            .build()


}