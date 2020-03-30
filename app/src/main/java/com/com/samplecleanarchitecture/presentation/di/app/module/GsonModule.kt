package com.com.samplecleararchitecture.presentation.di.app.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object GsonModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideGson() = Gson()
}