package com.data.repository.remote

import com.data.model.ItemData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("item?id={id}")
    fun getItem(@Path("id") id: Int): Deferred<ItemData>

}