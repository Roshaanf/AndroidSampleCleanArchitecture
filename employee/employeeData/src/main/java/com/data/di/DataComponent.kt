package com.data.di

import com.avanza.basedomain.di.BaseDataComponent
import com.data.di.module.DataModule
import com.data.di.module.RoomModule
import com.domain.di.require.DataProvider
import dagger.Component

@Component(dependencies = [BaseDataComponent::class],modules = [DataModule::class, RoomModule::class])
internal interface DataComponent : DataProvider {


}