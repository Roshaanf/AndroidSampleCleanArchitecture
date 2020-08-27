package com.data.repository.remote

import com.basedata.di.scope.DataScope
import javax.inject.Inject


@DataScope
class EmployeeRemoteDataSource @Inject constructor(
    private val employeeService: EmployeeService
) {

    suspend fun getEmployees() = employeeService.getEmployees()
    suspend fun getEmployee(id: Int) = employeeService.getEmplyee(id)
}