package com.domain.common


sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T?) : Result<T>()
    class Error(val errorMessage: String) : Result<Nothing>()
    class Exception(val exception: java.lang.Exception) : Result<Nothing>()
}