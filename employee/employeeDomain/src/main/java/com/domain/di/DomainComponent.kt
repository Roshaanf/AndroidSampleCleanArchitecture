package com.domain.di

import com.avanza.basedomain.DomainScope
import com.domain.di.expose.DomainExposer
import com.domain.di.require.DataProvider
import dagger.Component

//this is internal component means cant be accessed outside this module
//to expose dependencies to presentation there is DomainExposer
@DomainScope
@Component(dependencies = [DataProvider::class])
internal interface DomainComponent : DomainExposer {
}