package com.basepresentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel() {
    protected val _uiEvent: MutableLiveData<BaseEvent<UIEvents>> = MutableLiveData()
    val obUiEvent: LiveData<BaseEvent<UIEvents>> = _uiEvent


    protected fun showError(message: String?) {
        _uiEvent.value = (BaseEvent(UIEvents.Error(message!!)))
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