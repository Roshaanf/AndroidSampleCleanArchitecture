package com.presentation.mapper

import com.data.db.entity.EmployeeData
import com.domain.entity.EmployeeEntity
import com.presentation.model.Employee

fun transform(employeeEntity: EmployeeEntity) =
    employeeEntity.run {
        Employee(
            id,
            name,
            salary,
            age,
            image
        )
    }

fun transform(employeeEntity: List<EmployeeEntity>) =
    mutableListOf<Employee>()
        .apply {
            employeeEntity.forEach {
                add(transform(it))
            }
        }
