package com.presentation.di

import com.basepresentation.di.BasePresentationComponent
import com.basepresentation.di.scope.PresentationScope
import com.domain.di.expose.DomainExposer
import com.presentation.ItemDetail

import dagger.Component

@PresentationScope
@Component(
    dependencies = [BasePresentationComponent::class,
        DomainExposer::class]
)
internal interface PresentationComponent {
    fun inject(itemDetail: ItemDetail)
}