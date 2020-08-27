package com.domain.repository

import com.basedomain.Result
import com.domain.entity.EmployeeEntity


interface GetEmployeeRepository {
    suspend fun getEmployee(id: Int): Result<EmployeeEntity>
}