package com.avanza.basedomain.di.modules

import com.avanza.basedomain.di.scope.BaseDataScope
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