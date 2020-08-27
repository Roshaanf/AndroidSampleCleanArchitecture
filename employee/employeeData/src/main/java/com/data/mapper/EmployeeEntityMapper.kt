package com.data.mapper

import com.data.model.EmployeeData
import com.domain.entity.EmployeeEntity


fun transform(employeeData: EmployeeData?): EmployeeEntity = if (employeeData == null)
    EmployeeEntity()
else
    EmployeeEntity(
        employeeData.id,
        employeeData.employee_name,
        employeeData.employee_salary,
        employeeData.employee_age,
        employeeData.profile_image
    )


fun transform(employees: List<EmployeeData>?): List<EmployeeEntity> = if (employees == null)
    mutableListOf()
else
    mutableListOf<EmployeeEntity>().also { list ->
        employees.forEach {
            list.add(transform(it))
        }
    }


