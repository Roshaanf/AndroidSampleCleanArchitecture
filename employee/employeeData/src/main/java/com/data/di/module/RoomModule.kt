package com.data.di.module

import android.content.Context
import androidx.room.Room
import com.basedata.di.scope.DataScope
import com.data.R
import com.data.db.EmployeeDb
import dagger.Module
import dagger.Provides

@Module
internal object RoomModule {

    @Synchronized
    @JvmStatic
    @Provides
    @DataScope
    fun providesDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            EmployeeDb::class.java,
            context.getString(R.string.db_name)
        ).build()

}