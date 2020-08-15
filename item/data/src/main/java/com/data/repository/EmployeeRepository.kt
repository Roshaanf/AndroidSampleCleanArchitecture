package com.data.repository


import com.avanza.basedomain.getDataOrException
import com.data.mapper.transform
import com.data.repository.local.EmployeeLocalDataSource
import com.data.repository.remote.EmployeeRemoteDataSource
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeeRepository
import com.domain.repository.GetEmployeesRepository

class EmployeeRepository constructor(
    private val employeeLocalDataSource: EmployeeLocalDataSource,
    private val employeeRemoteDataSource: EmployeeRemoteDataSource
) :
    GetEmployeesRepository,
    GetEmployeeRepository {


    override suspend fun getEmployees(): Result<List<EmployeeEntity>> =
        com.avanza.basedomain.runOnIOThread {
            com.avanza.basedomain.toResult(
                employeeRemoteDataSource
                    .getEmployees()
                    .getDataOrException()
                    .run(::transform)
            )
        }


    override suspend fun getItem(id: Int): Result<EmployeeEntity> =
        com.avanza.basedomain.runOnIOThread {
            com.avanza.basedomain.toResult(
                employeeRemoteDataSource
                    .getEmployee(id)
                    .getDataOrException()
                    .run(::transform)
            )
        }


}