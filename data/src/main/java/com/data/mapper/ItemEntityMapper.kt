package com.data.mapper

import com.data.model.ItemData
import com.domain.entity.ItemEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ItemEntityMapper {

    fun transform(item: ItemData): ItemEntity {
        throw NotImplementedError()
    }

    fun transform(item: ItemEntity): ItemData {
        throw NotImplementedError()
    }
}