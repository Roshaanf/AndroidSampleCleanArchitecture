package com.domain.repository

import com.avanza.basedomain.Result
import com.domain.entity.EmployeeEntity


interface GetEmployeesRepository {
    suspend fun getEmployees(): Result<List<EmployeeEntity>>
}
