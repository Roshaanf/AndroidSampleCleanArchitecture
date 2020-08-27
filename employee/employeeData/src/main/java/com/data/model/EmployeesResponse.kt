package com.data.model

import com.data.db.entity.EmployeeData

data class EmployeesResponse(
    val status: String?,
    val data: List<EmployeeData?>?
)