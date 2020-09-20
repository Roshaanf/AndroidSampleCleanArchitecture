package com.aboutpresentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aboutdomain.usecase.FetchAboutUsUseCase
import com.basedomain.Result
import com.basepresentation.base.BaseViewModel
import com.basepresentation.di.scope.PresentationScope
import com.basepresentation.util.parseError
import kotlinx.coroutines.async
import javax.inject.Inject

@PresentationScope
internal class AboutUsViewModel @Inject constructor(private val fetchAboutUsUseCase: FetchAboutUsUseCase) :
    BaseViewModel() {

    private val _aboutUsText: MutableLiveData<String> = MutableLiveData()
    val aboutUsText: LiveData<String>
        get() = _aboutUsText

    init {
        showLoader()

        viewModelScope.async {
            when (val result = fetchAboutUsUseCase()) {
                is Result.Success -> {
                    hideLoader()
                    _aboutUsText.value = result.data
                }
                is Result.Error -> {
                    showError(parseError(result.exception))
                }
            }
        }
    }
}