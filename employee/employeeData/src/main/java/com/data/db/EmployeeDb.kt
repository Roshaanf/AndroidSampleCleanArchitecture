package com.avanza.basedomain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.model.EmployeeData

/*
* This db is only for saving common tables between features,
* each feature will have its own db
* */
@Database(entities = [EmployeeData::class], version = 1)
abstract class EmployeeDb : RoomDatabase() {

    abstract fun commonDao(): EmployeeDao

}