package com.basedata

import android.app.Application
import com.basedata.di.BaseDataComponent
import com.basedata.di.DaggerBaseDataComponent

open class BaseDataApplication : Application() {


    companion object {
        lateinit var baseDataComponent: BaseDataComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

//        building base data component
        baseDataComponent = DaggerBaseDataComponent
            .factory()
            .create(this)

    }
}