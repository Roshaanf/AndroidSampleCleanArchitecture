package com.basedata

class UnAuthenticatedException(private val errorMessage: String?) : Exception(errorMessage)
class ResourceNotFound(private val errorMessage: String?) : Exception(errorMessage)
class ConverterException(private val errorMessage: String?) : Exception(errorMessage)
class ConnectivityException(private val errorMessage: String?) : Exception(errorMessage)
