package com.domain.repository

import com.domain.common.Result
import com.domain.entity.ItemEntity


interface GetItemRepository {
    suspend fun getItem(id: Int): Result<ItemEntity>
}