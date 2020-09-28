package com.basedata.di.modules

import com.basedata.BuildConfig
import com.basedata.network.ResultCallAdapterFactory
import com.basedata.di.scope.BaseDataScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
internal object RetrofitModule {


    @JvmStatic
    @Provides
    @BaseDataScope
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
    @BaseDataScope
    fun provideGsonConverter(gson: Gson) = GsonConverterFactory.create(gson)
}