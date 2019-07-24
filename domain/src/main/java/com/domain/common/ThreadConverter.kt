package com.domain.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RunOnBackgroundThread {

    inline suspend operator fun <T : Any> invoke(crossinline call: suspend () -> Result<Any>) =
        withContext(Dispatchers.Default) {
            call()
        } as Result<T>

}