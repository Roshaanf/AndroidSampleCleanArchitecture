package com.aapa.di.profile.component

import com.aapa.di.profile.module.ItemDetailModule
import com.aapa.di.profile.scope.ItemDetailScope
import com.com.samplecleanarchitecture.presentation.itemdetail.ItemDetail
import com.com.samplecleararchitecture.presentation.di.screen.component.ScreenComponent
import dagger.Component

@ItemDetailScope
@Component(dependencies = [ScreenComponent::class], modules = [ItemDetailModule::class])
interface ItemDetailComponent {
    fun inject(itemDetail: ItemDetail)
}