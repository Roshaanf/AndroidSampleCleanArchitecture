package com.data.repository.remote

import com.data.model.EmployeeData
import com.domain.common.Result
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EmployeeService {

//    @GET("item?id={id}")
//    fun getItem(@Path("id") id: Int): Deferred<ItemData>
//

    @GET("v1/employees")
    suspend fun getEmployees(): Result<List<EmployeeData>>

    @GET("v1/employee/USER_ID")
    suspend fun getEmplyee(
        @Path(
            value = "USER_ID",
            encoded = true
        ) userId: Int
    ): Result<EmployeeData>


}