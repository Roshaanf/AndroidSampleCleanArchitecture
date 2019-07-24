package com.domain.usecase

import com.domain.common.Result
import com.domain.common.RunOnBackgroundThread
import com.domain.entity.ItemEntity
import com.domain.repository.GetItemRepository


class GetItemUseCase constructor(
    private val getItemRepository: GetItemRepository,
    private val runOnBackgroundThread: RunOnBackgroundThread
) {

    suspend operator fun invoke(id: Int): Result<ItemEntity> =
        runOnBackgroundThread {
            getItemRepository.getItem(id)
        }
}