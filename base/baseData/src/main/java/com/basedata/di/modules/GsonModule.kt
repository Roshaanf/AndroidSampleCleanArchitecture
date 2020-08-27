package com.basedata.di.modules

import com.basedata.di.scope.BaseDataScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
internal object GsonModule {

    @JvmStatic
    @Provides
    @BaseDataScope
    fun provideGson() = Gson()
}