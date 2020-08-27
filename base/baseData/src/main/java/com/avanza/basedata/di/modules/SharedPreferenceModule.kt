package com.avanza.basedomain.di.modules

import android.content.Context
import com.data.common.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object SharedPreferenceModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideSharePreference(context: Context) = context.getSharedPreferences(
        SharedPreferenceManager.SharedPrefConst.SHARED_PREF_FILE, Context.MODE_PRIVATE
    )


}