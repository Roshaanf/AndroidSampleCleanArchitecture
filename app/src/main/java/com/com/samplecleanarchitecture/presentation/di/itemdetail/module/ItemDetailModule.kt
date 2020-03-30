package com.aapa.di.profile.module

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.aapa.di.profile.scope.ItemDetailScope
import dagger.Module
import dagger.Provides

@Module
object ItemDetailModule {

    @JvmStatic
    @ItemDetailScope
    @Provides
    fun provideLayoutManager(context: Context) = GridLayoutManager(context, 3)
}