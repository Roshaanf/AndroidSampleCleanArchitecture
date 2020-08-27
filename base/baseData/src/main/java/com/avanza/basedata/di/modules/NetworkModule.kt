package com.avanza.basedomain.di.modules

import com.avanza.basedomain.di.scope.BaseDataScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
internal object NetworkModule {

    @JvmStatic
    @Provides
    @BaseDataScope
    fun provideOkHttp() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}