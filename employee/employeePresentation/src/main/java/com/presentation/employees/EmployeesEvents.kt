package com.presentation.employees

import com.domain.entity.EmployeeEntity

internal sealed class EmployeesEvents {
    class EMPLOYEES_FETCHED(val list: List<EmployeeEntity>) : EmployeesEvents()
    class OPEN_EMPLOYEE_DETAIL(val employeeId: Int) : EmployeesEvents()
}