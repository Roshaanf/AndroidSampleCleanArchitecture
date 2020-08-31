package com.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.domain.usecase.GetItemUseCase
import kotlinx.coroutines.async
import com.basedomain.Result
import com.basepresentation.base.BaseEvent
import com.basepresentation.base.BaseViewModel
import com.basepresentation.di.scope.PresentationScope
import com.basepresentation.util.parseError
import javax.inject.Inject

@PresentationScope
class ItemDetailViewModel
@Inject constructor(
    private val getItemUseCase: GetItemUseCase,
    val itemDetailUiModel: ItemDetailUiModel
) :
    BaseViewModel() {

    private val _events = MutableLiveData<BaseEvent<ItemDetailEvents>>()
    val events: LiveData<BaseEvent<ItemDetailEvents>>
        get() = _events

    init {
        showLoader()

        viewModelScope.async {
            when (val result = getItemUseCase(1)) {
                is Result.Success -> {
                    hideLoader()
                    itemDetailUiModel.map(result.data ?: return@async)
                }
                is Result.Error -> {
                    showError(parseError(result.exception))
                }
            }
        }

    }

    fun onAboutUsClicked() {
        _events.value = BaseEvent(ItemDetailEvents.OPEN_ABOUT_US)
    }

}