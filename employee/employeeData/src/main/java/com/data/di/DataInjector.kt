package com.data.di

import com.basedata.BaseDataApplication
import com.domain.di.require.DataRequire

object DataInjector {

    lateinit var dataProvider: DataRequire
        private set

    fun create(): DataRequire {
        dataProvider = DaggerDataComponent
            .builder()
            .baseDataComponent(BaseDataApplication.baseDataComponent)
            .build()

        return dataProvider
    }
}