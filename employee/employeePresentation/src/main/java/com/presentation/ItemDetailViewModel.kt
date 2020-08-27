package com.presentation

import androidx.lifecycle.viewModelScope
import com.domain.usecase.GetItemUseCase
import kotlinx.coroutines.async
import com.basedomain.Result
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

}