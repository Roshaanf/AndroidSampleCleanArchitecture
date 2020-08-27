package com.data.repository.remote

import com.data.db.entity.EmployeeData
import com.basedomain.Result
import com.data.model.EmployeeResponse
import com.data.model.EmployeesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeService {

//    @GET("item?id={id}")
//    fun getItem(@Path("id") id: Int): Deferred<ItemData>
//

    @GET("v1/employees")
    suspend fun getEmployees(): Result<EmployeesResponse>

    @GET(
        "v1/employee/" +
                "{USER_ID}"
    )
    suspend fun getEmplyee(
        @Path(
            value = "USER_ID",
            encoded = true
        ) userId: Int
    ): Result<EmployeeResponse>


}