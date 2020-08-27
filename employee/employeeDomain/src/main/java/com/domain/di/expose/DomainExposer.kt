package com.domain.di.expose

import com.domain.usecase.GetItemUseCase
import com.domain.usecase.GetItemsUseCase

interface DomainExposer {
    fun exposeGetItemsUseCase(): GetItemsUseCase
    fun exposeGetItemUseCase(): GetItemUseCase
}