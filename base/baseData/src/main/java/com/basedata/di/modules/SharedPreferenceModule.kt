package com.basedata.di.modules

import android.content.Context
import com.basedata.SharedPreferenceManager
import com.basedata.di.scope.BaseDataScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object SharedPreferenceModule {

    @Provides
    @BaseDataScope
    @JvmStatic
    fun provideSharePreference(context: Context) = context.getSharedPreferences(
        SharedPreferenceManager.SharedPrefConst.SHARED_PREF_FILE, Context.MODE_PRIVATE
    )


}