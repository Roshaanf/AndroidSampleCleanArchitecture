package com.basepresentation.di.module

import android.content.Context
import com.basepresentation.di.qualifier.ApplicationContext
import com.basepresentation.di.qualifier.Glide
import com.basepresentation.di.scope.BasePresentationScope
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides

@Module
object GlideModule {

//    TODO remove qualfier and make Named
    @JvmStatic
    @Provides
    @Glide("Glide")
    @BasePresentationScope
    fun provideGlide(@ApplicationContext context: Context): RequestManager = com.bumptech.glide.Glide.with(context)
}