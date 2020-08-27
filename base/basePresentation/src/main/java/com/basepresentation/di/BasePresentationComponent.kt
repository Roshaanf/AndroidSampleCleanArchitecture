package com.basepresentation.di

import android.content.Context
import com.basepresentation.di.module.GlideModule
import com.basepresentation.di.qualifier.ApplicationContext
import com.basepresentation.di.scope.BasePresentationScope
import com.basepresentation.factory.SpannableStringFactory
import com.basepresentation.factory.ToastFactory
import dagger.BindsInstance
import dagger.Component

@BasePresentationScope
@Component(modules = [GlideModule::class])
interface BasePresentationComponent {

    fun exposeSpannableStringFactory(): SpannableStringFactory
    fun toastFactory(): ToastFactory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance @ApplicationContext context: Context):BasePresentationComponent
    }
}