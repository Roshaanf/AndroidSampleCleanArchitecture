package com.aboutdata.di

import com.aboutdomain.di.require.DataRequire
import com.basedata.di.scope.DataScope
import dagger.Component

@DataScope
@Component(modules = [DataModule::class])
interface DataComponent : DataRequire {
}