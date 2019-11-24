package com.data.repository


import com.data.mapper.ItemEntityMapper
import com.data.repository.local.ItemLocalDataSource
import com.data.repository.remote.ItemRemoteDataSource
import com.domain.common.Result
import com.domain.entity.ItemEntity
import com.domain.repository.GetItemRepository
import com.domain.repository.GetItemsRepository

class ItemDataRepository constructor(
    private val itemLocalDataSource: ItemLocalDataSource,
    private val itemRemoteDataSource: ItemRemoteDataSource,
    private val itemEntityMapper: ItemEntityMapper
) :
    GetItemsRepository,
    GetItemRepository {

    override suspend fun getItems(): Result<List<ItemEntity>> {
        throw Exception()
    }

    override suspend fun getItem(id: Int): Result<ItemEntity> {
        val result = itemRemoteDataSource.getItem(id)

        if (result is Result.Success)
            return Result.Success(itemEntityMapper.transform(result.data!!))

        return result as Result<Nothing>
    }


}