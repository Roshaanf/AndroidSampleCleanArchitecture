package com.avanza.aboutdomain.di.expose

import com.avanza.aboutdomain.usecase.FetchAboutUsUseCase

interface DomainExposer {
    fun exposeFetchAboutUsUseCase(): FetchAboutUsUseCase
}