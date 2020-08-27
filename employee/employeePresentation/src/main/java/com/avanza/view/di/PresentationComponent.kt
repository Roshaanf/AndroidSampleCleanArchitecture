package com.aapa.di.profile.component

import com.aapa.di.profile.module.PresentationModule
import com.avanza.basepresentation.di.BasePresentationComponent
import com.avanza.basepresentation.di.scope.PresentationScope
import com.avanza.view.ItemDetail

import dagger.Component

@PresentationScope
@Component(dependencies = [BasePresentationComponent::class], modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(itemDetail: ItemDetail)
}