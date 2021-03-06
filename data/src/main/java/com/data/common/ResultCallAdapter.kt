package com.data.common

import com.domain.common.Result
import okhttp3.Request
import retrofit2.*
import java.io.IOException
import java.lang.Exception
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultCallAdapterFactory @Inject constructor() : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ) = when (getRawType(returnType)) {
//        with suspend functions retrofit wraps return type with Class, if return type was
//        Result<Foo> then retrofit will look for Call<Result<Foo>>
        Call::class.java -> {
            val callType = getParameterUpperBound(0, returnType as ParameterizedType)
//            getRawType will return Result as a class
            when (getRawType(callType)) {
                Result::class.java -> {
//                    parameterUpperBound will return our actual unwrapped response type Foo
                    val resultType = getParameterUpperBound(0, callType as ParameterizedType)

                    ResultCallAdapter(resultType)
                }
//               null is telling retrofit that this CallAdapter can't handle the provided returnType
//                look for other CallAdapters to handle
                else -> null
            }
        }
//               null is telling retrofit that this CallAdapter can't handle the provided returnType
//                look for other CallAdapters to handle
        else -> null
    }

    class ResultCallAdapter(
        private val type: Type
    ) : CallAdapter<Type, Call<Result<Type>>> {

        override fun responseType() = type
        //        retrofit expects adapt to return instance of Call
        override fun adapt(call: Call<Type>): Call<Result<Type>> = ResultCall(call)
    }

    //    this ResultCall is required because retrofit expects CallAdapter.adapt to return
//    instance of Call, CallDelegate is implementing Call
    class ResultCall<T : Any>(call: Call<T>) : CallDelegate<T, Result<T>>(call) {

        override fun enqueueImpl(callback: Callback<Result<T>>) =

            proxy.enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val code: Int = response.code()


                    val result = if (code in 200 until 300)
                        Result.Success(response.body())
                    else if (code == 404)
                        Result.Error(ResourceNotFound("Resource Not Found"))
                    else if (code in 401..403)
                        Result.Error(UnAuthenticatedException("Unauthenticated"))
                    else
                        Result.Error(Exception(response.errorBody()?.string()))


                    callback.onResponse(this@ResultCall, Response.success(result))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {

                    val result = if (t is IOException)
//                        network error
                        Result.Error(ConnectivityException("Unable to connect to server"))
                    else
//                        converter/deserializing exception when server returns wrong json
                        Result.Error(ConverterException("Oops! Unexpected response"))


                    callback.onResponse(this@ResultCall, Response.success(result))
                }
            })

        override fun cloneImpl() = ResultCall(proxy.clone())
    }


    abstract class CallDelegate<TIn, TOut>(
        protected val proxy: Call<TIn>
    ) : Call<TOut> {
        override fun execute(): Response<TOut> = throw NotImplementedError()
        override final fun enqueue(callback: Callback<TOut>) = enqueueImpl(callback)
        override final fun clone(): Call<TOut> = cloneImpl()

        override fun cancel() = proxy.cancel()
        override fun request(): Request = proxy.request()
        override fun isExecuted() = proxy.isExecuted
        override fun isCanceled() = proxy.isCanceled

        abstract fun enqueueImpl(callback: Callback<TOut>)
        abstract fun cloneImpl(): Call<TOut>
    }


}