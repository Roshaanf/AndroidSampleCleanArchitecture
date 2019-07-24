package com.aapa.base

sealed class UIEvents {
    object ShowLoader : UIEvents()
    object HideLoader : UIEvents()
    class Exception(val message: String) : UIEvents()
    class Error(val message: String) : UIEvents()
    class Toast(val message: String) : UIEvents()
}