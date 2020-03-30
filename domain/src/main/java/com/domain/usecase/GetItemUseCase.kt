package com.domain.usecase

import com.domain.common.Result
import com.domain.common.runOnBackgroundThread
import com.domain.entity.EmployeeEntity
import com.domain.repository.GetEmployeeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetItemUseCase @Inject constructor(
    private val getItemRepository: GetEmployeeRepository
) {

    suspend operator fun invoke(id: Int): Result<EmployeeEntity> =
        runOnBackgroundThread {
            getItemRepository.getItem(id)
        }

}