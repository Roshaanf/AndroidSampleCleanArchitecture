package com.data.di.module

import com.basedata.di.scope.DataScope
import com.data.repository.remote.EmployeeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal object ServiceModule {

    @JvmStatic
    @DataScope
    @Provides
    fun providesEmployeeService(retrofit: Retrofit) =
        retrofit.create(EmployeeService::class.java)
}