package com.basedata.di

import android.content.Context
import com.basedata.SharedPreferenceManager
import com.basedata.di.modules.GsonModule
import com.basedata.di.modules.NetworkModule
import com.basedata.di.modules.RetrofitModule
import com.basedata.di.modules.SharedPreferenceModule
import com.basedata.di.scope.BaseDataScope
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

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


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): BaseDataComponent
    }
}