package com.com.samplecleararchitecture.presentation.di.screen.component

import com.com.samplecleararchitecture.presentation.di.screen.module.GlideModule
import com.com.samplecleararchitecture.presentation.di.screen.scope.ScreenScope
import dagger.Subcomponent

@ScreenScope
@Subcomponent(
//    dependencies = [AppComponent::class],
    modules = [GlideModule::class]
)
interface ScreenComponent {

//    subcomponet builder is mandatory when linking subcomponent to parent component via module.subcomponent
    @Subcomponent.Builder
    interface Builder{
        fun build():ScreenComponent
    }
}