package com.domain.usecase

import com.domain.common.Result
import com.domain.common.RunOnBackgroundThread
import com.domain.entity.ItemEntity
import com.domain.repository.GetItemsRepository


class GetItemsUseCase constructor(
    private val getItemsRepository: GetItemsRepository,
    private val runOnBackgroundThread: RunOnBackgroundThread
) {

    suspend operator fun invoke(): Result<List<ItemEntity>> =
        runOnBackgroundThread {
            val result = getItemsRepository.getItems()
            if (result is Result.Success)
                println("Asd")
            result
        }

}