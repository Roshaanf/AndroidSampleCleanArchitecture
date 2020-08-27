package com.domain.repository

import com.basedomain.Result
import com.domain.entity.EmployeeEntity


interface GetEmployeesRepository {
    suspend fun getEmployees(): Result<List<EmployeeEntity>>
}
