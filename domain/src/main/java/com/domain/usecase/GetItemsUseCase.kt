package com.domain.usecase

import com.domain.common.Result
import com.domain.common.runOnBackgroundThread
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeesRepository

class GetItemsUseCase constructor(
    private val getItemsRepository: GetEmployeesRepository
    ) {

    suspend operator fun invoke(): Result<List<EmployeeEntity>> =
        runOnBackgroundThread(getItemsRepository::getEmployees)

}