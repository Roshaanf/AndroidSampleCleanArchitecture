package com.data.common

import com.domain.common.Result
import kotlinx.coroutines.Deferred
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

class GeneralRequest {

    suspend operator fun <T : Any> invoke(request: () -> Deferred<T>): Result<T> =
        try {

            var response = request().await()

            Result.Success(response)


        } catch (exception: HttpException) {
//            this is the error from server
            Result.Error(parseError(exception.response()))
        } catch (exception: IOException) {
//            this is pure connectivity exception
            Result.Exception(ConnectivityException(exception))

        } catch (exception: Exception) {
//        this is conversion error
            Result.Exception(exception)

        }
}