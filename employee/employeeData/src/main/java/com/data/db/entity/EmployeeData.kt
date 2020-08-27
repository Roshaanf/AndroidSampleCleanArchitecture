package com.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class EmployeeData(
    @PrimaryKey
    val id: Int,
    val employee_name: String,
    val employee_salary: String,
    val employee_age: String,
    val profile_image: String
)