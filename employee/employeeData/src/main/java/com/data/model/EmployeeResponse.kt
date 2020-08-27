package com.data.model

import com.data.db.entity.EmployeeData

data class EmployeeResponse(
    val status: String?,
    val data: EmployeeData?,
    val message: String?
)