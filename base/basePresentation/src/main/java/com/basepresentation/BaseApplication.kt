package com.basepresentation

import android.app.Application
import com.basedata.BaseDataApplication
import com.basepresentation.di.BasePresentationComponent
import com.basepresentation.di.DaggerBasePresentationComponent

open class BaseApplication : BaseDataApplication() {

    companion object {
        lateinit var basePresentationComponent: BasePresentationComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

//        building base presentation component
        basePresentationComponent = DaggerBasePresentationComponent
            .factory()
            .create(this)

    }
}