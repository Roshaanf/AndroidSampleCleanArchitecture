package com.data.mapper

import com.data.db.entity.EmployeeData
import com.data.model.EmployeeResponse
import com.data.model.EmployeesResponse
import com.domain.entity.EmployeeEntity


fun transform(employeeResponse: EmployeeResponse?): EmployeeEntity = if (employeeResponse == null)
    EmployeeEntity()
else transform(employeeResponse.data)


private fun transform(employeeData: EmployeeData?) =
    if (employeeData == null) EmployeeEntity()
    else
        employeeData.run {
            EmployeeEntity(
                id,
                employee_name,
                employee_salary,
                employee_age,
                profile_image
            )
        }


fun transform(employees: EmployeesResponse?): List<EmployeeEntity> = if (employees == null)
    mutableListOf()
else
    mutableListOf<EmployeeEntity>().also { list ->
        employees.data?.forEach {
            list.add(transform(it))
        }
    }


