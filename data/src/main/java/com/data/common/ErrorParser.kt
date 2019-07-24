package com.data.common

import retrofit2.Response

fun parseError(response: Response<*>) =
    when (response.code()) {
        400 -> handle400Error(response)
        401 -> handle401Error(response)
        404 -> handle404Error()
        405 -> handle405Error()
        422 -> handle422Error(response)
        500 -> handle500Error()
        else -> handleUnknownError()
    }

private fun handle400Error(
    response: Response<*>
) = "Unhandled."

private fun handle401Error(
    response: Response<*>
) = "Unhandled"

private fun handle404Error() = "Unhandled"
private fun handle405Error() = "Unhandled"
private fun handle422Error(
    response: Response<*>
): String = "Unhandled"

private fun handle500Error() = "Unhandled"
private fun handleUnknownError() = "Unhandled"