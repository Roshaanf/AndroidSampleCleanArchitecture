package com.data.repository.remote


class EmployeeRemoteDataSource constructor(
    private val employeeService: EmployeeService
) {

    suspend fun getEmployees() = employeeService.getEmployees()
    suspend fun getEmployee(id:Int) = employeeService.getEmplyee(id)
}