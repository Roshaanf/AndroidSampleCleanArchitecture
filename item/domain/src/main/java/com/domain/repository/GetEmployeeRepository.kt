package com.domain.repository

import com.avanza.basedomain.Result
import com.domain.entity.EmployeeEntity


interface GetEmployeeRepository {
    suspend fun getItem(id: Int): Result<EmployeeEntity>
}