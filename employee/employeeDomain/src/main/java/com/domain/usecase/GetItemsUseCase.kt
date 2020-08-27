package com.domain.usecase

import com.avanza.basedomain.DomainScope
import com.avanza.basedomain.Result
import com.avanza.basedomain.runOnBackgroundThread
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeesRepository
import javax.inject.Inject

@DomainScope
class GetItemsUseCase @Inject constructor(
    private val getItemsRepository: GetEmployeesRepository
) {

    suspend operator fun invoke(): Result<List<EmployeeEntity>> =
        runOnBackgroundThread(getItemsRepository::getEmployees)

}