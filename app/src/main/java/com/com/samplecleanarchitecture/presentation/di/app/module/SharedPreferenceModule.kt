package com.com.samplecleararchitecture.presentation.di.app.module

import android.content.Context
import com.data.common.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object SharedPreferenceModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideSharePreference(context: Context) = context.getSharedPreferences(
        SharedPreferenceManager.SharedPrefConst.SHARED_PREF_FILE, Context.MODE_PRIVATE
    )


}