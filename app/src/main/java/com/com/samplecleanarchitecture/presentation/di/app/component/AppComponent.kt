package com.com.samplecleararchitecture.presentation.di.app.component

import android.content.Context
import com.com.samplecleararchitecture.presentation.di.app.module.*
import com.com.samplecleanarchitecture.presentation.AppClass
import com.com.samplecleararchitecture.presentation.di.screen.component.ScreenComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [GsonModule::class, NetworkModule::class, RetrofitModule::class,
        RoomModule::class, SharedPreferenceModule::class]
)
interface AppComponent {
    fun inject(appClass: AppClass)

    //    use this builder to inject screen component
    fun getScreenComponentBuilder(): ScreenComponent.Builder

    @dagger.Component.Factory
    interface Component {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}