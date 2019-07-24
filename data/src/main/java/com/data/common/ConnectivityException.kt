package com.data.common

import java.lang.Exception

class ConnectivityException(private val errorMessage: Exception) : Exception(errorMessage.message)