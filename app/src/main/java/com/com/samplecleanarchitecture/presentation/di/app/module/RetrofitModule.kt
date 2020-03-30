package com.com.samplecleararchitecture.presentation.di.app.module

import com.com.samplecleanarchitecture.BuildConfig
import com.data.common.ResultCallAdapterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object RetrofitModule {

    @JvmStatic
    @Provides
    @Singleton
    fun providesRetrofit(
        converterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient,
        resultCallAdapter: ResultCallAdapterFactory
    ) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(resultCallAdapter)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()


    @JvmStatic
    @Provides
    @Singleton
    fun provideGsonConverter(gson: Gson) = GsonConverterFactory.create(gson)
}