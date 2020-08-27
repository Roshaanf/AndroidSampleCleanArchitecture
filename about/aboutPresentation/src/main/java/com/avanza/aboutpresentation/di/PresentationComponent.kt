package com.avanza.aboutpresentation.di

import com.avanza.aboutdomain.di.expose.DomainExposer
import com.avanza.aboutpresentation.AboutActivity
import com.basepresentation.di.BasePresentationComponent
import com.basepresentation.di.scope.PresentationScope
import dagger.Component

@PresentationScope
@Component(
    dependencies = [
        DomainExposer::class]
)
interface PresentationComponent {
    fun inject(aboutActivity: AboutActivity)
}