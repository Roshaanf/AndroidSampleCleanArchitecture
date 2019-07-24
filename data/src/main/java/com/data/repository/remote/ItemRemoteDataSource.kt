package com.data.repository.remote

import com.data.common.GeneralRequest


class ItemRemoteDataSource constructor(
    private val apiInterface: ApiInterface,
    private val generalRequest: GeneralRequest
) {

    suspend fun getItem(id: Int) = generalRequest { apiInterface.getItem(id) }
}