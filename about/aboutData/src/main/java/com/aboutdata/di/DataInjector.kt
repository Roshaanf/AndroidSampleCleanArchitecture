package com.aboutdata.di

import com.aboutdomain.di.require.DataRequire

object DataInjector {

    fun create(): DataRequire =
        DaggerDataComponent
            .builder()
            .build()


}