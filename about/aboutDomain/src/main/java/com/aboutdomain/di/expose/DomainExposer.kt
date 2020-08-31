package com.aboutdomain.di.expose

import com.aboutdomain.usecase.FetchAboutUsUseCase


interface DomainExposer {
    fun exposeFetchAboutUsUseCase(): FetchAboutUsUseCase
}