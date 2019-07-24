package com.domain.repository

import com.domain.common.Result
import com.domain.entity.ItemEntity


interface GetItemsRepository {
    suspend fun getItems(): Result<List<ItemEntity>>
}
