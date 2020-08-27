package com.avanza.aboutdomain.di

import com.avanza.aboutdomain.di.expose.DomainExposer
import com.avanza.aboutdomain.di.require.DataRequire
import com.basedomain.DomainScope
import dagger.Component

//this is internal component means cant be accessed outside this module
//to expose dependencies to presentation there is DomainExposer
@DomainScope
@Component(dependencies = [DataRequire::class])
internal interface DomainComponent:DomainExposer {
}