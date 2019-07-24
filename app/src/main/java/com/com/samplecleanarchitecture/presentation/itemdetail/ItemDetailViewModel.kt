package com.com.samplecleanarchitecture.presentation.itemdetail

import com.com.samplecleanarchitecture.presentation.base.BaseViewModel
import com.domain.common.Result
import com.domain.usecase.GetItemUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel

class ItemDetailViewModel constructor(
    private val getItemUseCase: GetItemUseCase,
    val itemDetailUiModel: ItemDetailUiModel
) :
    BaseViewModel(),
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    init {
        showLoader()

        async {
            when (val result = getItemUseCase(0)) {
                is Result.Success -> {
                    hideLoader()

                    itemDetailUiModel.map(result.data ?: return@async)
                }
                is Result.Error -> println("")
                is Result.Exception -> showException(result.exception)
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }
}