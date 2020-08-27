package com.avanza.aboutdata.di

import com.avanza.aboutdomain.di.require.DataRequire

object DataInjector {
    lateinit var dataProvider: DataRequire
        private set

    fun create(): DataRequire {
        dataProvider = DaggerDataComponent
            .builder()
            .build()

        return dataProvider
    }
}