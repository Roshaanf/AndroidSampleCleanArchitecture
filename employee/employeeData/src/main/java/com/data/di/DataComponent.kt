package com.data.di

import com.basedata.di.BaseDataComponent
import com.basedata.di.scope.DataScope
import com.data.di.module.DataModule
import com.data.di.module.RoomModule
import com.data.di.module.ServiceModule
import com.domain.di.require.DataRequire
import dagger.Component

@DataScope
@Component(dependencies = [BaseDataComponent::class],modules = [DataModule::class,
    RoomModule::class,ServiceModule::class])
internal interface DataComponent : DataRequire {


}