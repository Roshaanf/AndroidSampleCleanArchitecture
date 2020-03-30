package com.com.samplecleararchitecture.presentation.di.screen.module

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.com.samplecleararchitecture.presentation.di.screen.scope.ScreenScope
import dagger.Module
import dagger.Provides

@Module
object GlideModule {

//    TODO remove qualfier and make Named
    @JvmStatic
    @Provides
    @com.com.samplecleanarchitecture.presentation.di.screen.qualifier.Glide("Glide")
    @ScreenScope
    fun provideGlide(context: Context): RequestManager = Glide.with(context)
}