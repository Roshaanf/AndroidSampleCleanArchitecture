package com.data.di.module

import android.content.Context
import androidx.room.Room
import com.avanza.basedomain.di.scope.BaseDataScope
import com.avanza.basedomain.di.scope.DataScope
import com.avanza.basedomain.local.EmployeeDb
import com.data.R
import dagger.Module
import dagger.Provides

@Module
object RoomModule {

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