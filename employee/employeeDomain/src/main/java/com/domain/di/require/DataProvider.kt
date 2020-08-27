package com.domain.di.require

import com.domain.repository.GetEmployeeRepository
import com.domain.repository.GetEmployeesRepository


interface DataProvider {
    fun employeeRepository():GetEmployeeRepository
    fun employeesRepository(): GetEmployeesRepository
}