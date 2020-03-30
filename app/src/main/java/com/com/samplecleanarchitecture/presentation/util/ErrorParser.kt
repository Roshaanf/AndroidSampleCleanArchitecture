package com.com.samplecleanarchitecture.presentation.util


import com.data.common.ConnectivityException
import com.data.common.ConverterException
import com.data.common.ResourceNotFound
import com.data.common.UnAuthenticatedException
import java.lang.Exception

fun parseError(response: Exception) =
    when (response) {
        is UnAuthenticatedException -> handleUnAuthenticatedException(response)
        is ResourceNotFound -> handleResourceNotFoundException(response)
        is ConnectivityException -> handleConnectivityException(response)
        is ConverterException -> handleConverterException(response)
        else -> response.message
    }

private fun handleUnAuthenticatedException(response: Exception) = response.message
private fun handleResourceNotFoundException(response: Exception) = response.message
private fun handleConnectivityException(response: Exception) = response.message
private fun handleConverterException(response: Exception) = response.message
