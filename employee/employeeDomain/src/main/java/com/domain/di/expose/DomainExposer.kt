package com.domain.di.expose

import com.domain.usecase.GetEmployeeUseCase
import com.domain.usecase.GetEmployeesUseCase

interface DomainExposer {
    fun exposeGetItemsUseCase(): GetEmployeesUseCase
    fun exposeGetItemUseCase(): GetEmployeeUseCase
}