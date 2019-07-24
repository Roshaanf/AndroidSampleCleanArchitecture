package com.com.samplecleanarchitecture.presentation.itemdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.domain.entity.ItemEntity

class ItemDetailUiModel {

    private val _title: MutableLiveData<String> = MutableLiveData()
    val title: LiveData<String>
        get() = _title

    fun map(itemDetail: ItemEntity) {
        _title.value = itemDetail.name
    }
}