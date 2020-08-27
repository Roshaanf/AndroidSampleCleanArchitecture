package com.avanza.basedomain.di

import com.avanza.basedomain.di.modules.GsonModule
import com.avanza.basedomain.di.modules.NetworkModule
import com.avanza.basedomain.di.modules.RetrofitModule
import com.avanza.basedomain.di.modules.SharedPreferenceModule
import com.avanza.basedomain.di.scope.BaseDataScope
import com.data.common.SharedPreferenceManager
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@BaseDataScope
@Component(
    modules = [GsonModule::class, NetworkModule::class, RetrofitModule::class,
        SharedPreferenceModule::class]
)
interface BaseDataComponent {

    //    Exposing following dependencies to dependent components
    fun exposeRetrofit(): Retrofit
    fun exposeSharedPreferneceManager(): SharedPreferenceManager
    fun exposeGson(): Gson
}