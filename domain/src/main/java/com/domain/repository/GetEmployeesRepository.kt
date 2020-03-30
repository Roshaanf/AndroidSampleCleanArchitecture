package com.domain.repository

import com.domain.common.Result
import com.domain.entity.EmployeeEntity


interface GetEmployeesRepository {
    suspend fun getEmployees(): Result<List<EmployeeEntity>>
}
