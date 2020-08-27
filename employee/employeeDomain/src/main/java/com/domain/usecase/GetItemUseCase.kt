package com.domain.usecase

import com.basedomain.DomainScope
import com.basedomain.Result
import com.basedomain.runOnBackgroundThread
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