package com.data.repository.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.model.ItemData
import com.data.repository.local.db.dao.ItemDao


@Database(entities = [ItemData::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun itemDao(): ItemDao

}