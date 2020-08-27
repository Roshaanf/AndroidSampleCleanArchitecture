package com.avanza.basedomain.di.modules

import com.avanza.basedomain.BuildConfig
import com.avanza.basedomain.di.scope.BaseDataScope
import com.data.common.ResultCallAdapterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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