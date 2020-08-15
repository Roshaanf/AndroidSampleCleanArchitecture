package com.domain.repository

import com.domain.common.Result
import com.domain.entity.EmployeeEntity


interface GetEmployeeRepository {
    suspend fun getItem(id: Int): Result<EmployeeEntity>
}