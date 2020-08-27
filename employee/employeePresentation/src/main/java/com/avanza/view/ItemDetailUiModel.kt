package com.avanza.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aapa.di.profile.scope.ItemDetailScope
import com.domain.entity.EmployeeEntity
import javax.inject.Inject

@ItemDetailScope
class ItemDetailUiModel
@Inject constructor() {

    private val _title: MutableLiveData<String> = MutableLiveData()
    val title: LiveData<String>
        get() = _title

    fun map(itemDetail: EmployeeEntity) {
        _title.value = itemDetail.name
    }
}