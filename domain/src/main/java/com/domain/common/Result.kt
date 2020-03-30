package com.domain.common

import java.lang.Exception


sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T?) : Result<T>()
    class Error(val exception: Exception) : Result<Nothing>()
}

fun <T : Any> Result<T>.getDataOrException(): T? =
    if (this is Result.Success) this.data else throw this.getException()!!

fun <T : Any> Result<T>.getData(): T? =
    if (this is Result.Success) this.data else null

fun <T : Any> Result<T>.getException(): Exception? =
    if (this is Result.Error) this.exception else null

fun <T : Any> Result<T>.isSuccess() = this is Result.Success

fun <T : Any> toResult(data: T?): Result<T> =
    try {
        Result.Success(data)
    } catch (e: Exception) {
        Result.Error(e)
    }


