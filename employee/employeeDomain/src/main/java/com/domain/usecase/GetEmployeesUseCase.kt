package com.domain.usecase

import com.basedomain.DomainScope
import com.basedomain.Result
import com.basedomain.runOnBackgroundThread
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeesRepository
import javax.inject.Inject

@DomainScope
class GetEmployeesUseCase @Inject constructor(
    private val getItemsRepository: GetEmployeesRepository
) {

    suspend operator fun invoke(): Result<List<EmployeeEntity>> =
        runOnBackgroundThread(getItemsRepository::getEmployees)

}