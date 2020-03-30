package com.com.samplecleararchitecture.presentation.di.app.module

import android.content.Context
import androidx.room.Room
import com.com.samplecleanarchitecture.R
import com.data.repository.local.db.AppDb
import dagger.Module
import dagger.Provides

@Module
object RoomModule {

    @Synchronized
    @JvmStatic
    @Provides
    fun providesDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            AppDb::class.java,
            context.getString(R.string.db_name)
        ).build()

}