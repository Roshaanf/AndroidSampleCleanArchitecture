package com.data.di

import com.basedata.BaseDataApplication
import com.domain.di.require.DataProvider

object DataInjector {

    lateinit var dataProvider: DataProvider
        private set

    fun create(): DataProvider {
        dataProvider = DaggerDataComponent
            .builder()
            .baseDataComponent(BaseDataApplication.baseDataComponent)
            .build()

        return dataProvider
    }
}