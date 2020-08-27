package com.data.repository


import com.basedata.di.scope.DataScope
import com.data.mapper.transform
import com.data.repository.local.EmployeeLocalDataSource
import com.data.repository.remote.EmployeeRemoteDataSource
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeeRepository
import com.domain.repository.GetEmployeesRepository
import com.basedomain.Result
import com.basedomain.getDataOrException
import com.basedomain.runOnIOThread
import com.basedomain.toResult
import javax.inject.Inject

@DataScope
internal class EmployeeRepository @Inject constructor(
    private val employeeLocalDataSource: EmployeeLocalDataSource,
    private val employeeRemoteDataSource: EmployeeRemoteDataSource
) :
    GetEmployeesRepository,
    GetEmployeeRepository {


    override suspend fun getEmployees(): Result<List<EmployeeEntity>> =
        runOnIOThread {
            toResult {
                employeeRemoteDataSource
                    .getEmployees()
                    .getDataOrException()
                    .run(::transform)
            }
        }


    override suspend fun getEmployee(id: Int): Result<EmployeeEntity> =
        runOnIOThread {
            toResult {
                employeeRemoteDataSource
                    .getEmployee(id)
                    .getDataOrException()
                    .run(::transform)
            }
        }


}