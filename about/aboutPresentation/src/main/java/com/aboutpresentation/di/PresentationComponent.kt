package com.aboutpresentation.di

import com.aboutdomain.di.expose.DomainExposer
import com.aboutpresentation.AboutActivity
import com.basepresentation.di.BasePresentationComponent
import com.basepresentation.di.scope.PresentationScope
import dagger.Component

@PresentationScope
@Component(
    dependencies = [
        DomainExposer::class]
)
internal interface PresentationComponent {
    fun inject(aboutActivity: AboutActivity)
}