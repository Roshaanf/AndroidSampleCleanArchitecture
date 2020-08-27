package com.avanza.basedomain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//    using cross inline because we are calling call from another lambda which is not an inline(withContet)
//    function, if withContext was an inline function there was no need to use crossinline modifier,
//    crossinline will restrict call function to use return in its body hence restricting non local control fow inside lambda,
//    non local control flow inside lmabda is not allowed, control flow means instructions like goto or return etc

/*
Dispatchers.Default should be used for calculations, or CPU intensive tasks. It’s limited by the shared pool of threads the
size of the CPU cores count.*/
inline suspend fun <R : Any> runOnBackgroundThread(crossinline call: suspend () -> Result<R>) =
    withContext(Dispatchers.Default) {
        call()
    }


/*
Dispatchers.IO is usually used for fetching the data from network, database, etc.
— operations that are not CPU intensive. It is backed by a shared pool of 64 threads.
*/
inline suspend fun <R : Any> runOnIOThread(crossinline call: suspend () -> Result<R>) =
    withContext(Dispatchers.IO) {
        call()
    }

