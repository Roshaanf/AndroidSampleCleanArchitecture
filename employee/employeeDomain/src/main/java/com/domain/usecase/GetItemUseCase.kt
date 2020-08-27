package com.domain.usecase

import com.avanza.basedomain.DomainScope
import com.avanza.basedomain.Result
import com.avanza.basedomain.runOnBackgroundThread
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeeRepository
import javax.inject.Inject

@DomainScope
class GetItemUseCase @Inject constructor(
    private val getItemRepository: GetEmployeeRepository
) {

    suspend operator fun invoke(id: Int): Result<EmployeeEntity> =
        runOnBackgroundThread {
            getItemRepository.getEmployee(id)
        }

}