package com.com.samplecleanarchitecture.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aapa.base.BaseEvent
import com.aapa.base.UIEvents

open class BaseViewModel : ViewModel() {
    protected val _uiEvent: MutableLiveData<BaseEvent<UIEvents>> = MutableLiveData()
    val obUiEvent: LiveData<BaseEvent<UIEvents>> = _uiEvent


    protected fun showError(message: String?) {
        _uiEvent.value = (BaseEvent(UIEvents.Error(message!!)))
        hideLoader()
    }

    protected fun showException(exception: Exception) {
        _uiEvent.value = BaseEvent(UIEvents.Exception(exception.message!!))
        hideLoader()
    }

    protected fun showLoader() {
        _uiEvent.value = BaseEvent(UIEvents.ShowLoader)
    }

    protected fun hideLoader() {
        _uiEvent.value = BaseEvent(UIEvents.HideLoader)
    }


    protected fun showToast(message: String) {
        _uiEvent.value = BaseEvent(UIEvents.Toast(message))
    }

}