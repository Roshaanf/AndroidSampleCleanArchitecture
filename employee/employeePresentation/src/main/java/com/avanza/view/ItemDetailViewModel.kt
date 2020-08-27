package com.avanza.view

import androidx.lifecycle.viewModelScope
import com.aapa.di.profile.scope.ItemDetailScope
import com.avanza.basepresentation.di.scope.PresentationScope
import com.com.samplecleanarchitecture.presentation.base.BaseViewModel
import com.com.samplecleanarchitecture.presentation.util.parseError
import com.domain.common.Result
import com.domain.usecase.GetItemUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import javax.inject.Inject

@PresentationScope
class ItemDetailViewModel
@Inject constructor(
    private val getItemUseCase: GetItemUseCase,
    val itemDetailUiModel: ItemDetailUiModel
) :
    BaseViewModel() {

    init {
        showLoader()

        viewModelScope.async {
            when (val result = getItemUseCase(0)) {
                is Result.Success -> {
                    hideLoader()
                    itemDetailUiModel.map(result.data ?: return@async)
                }
                is Result.Error -> showError(parseError(result.exception))
            }
        }

    }

}