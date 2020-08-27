package com.data.di.module

import com.data.repository.EmployeeRepository
import com.domain.repository.GetEmployeeRepository
import com.domain.repository.GetEmployeesRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataModule {
    @Binds
    abstract fun bindEmployeeRepository(repository: EmployeeRepository): GetEmployeeRepository
    @Binds
    abstract fun bindEmployeesRepository(repository: EmployeeRepository): GetEmployeesRepository
}