package com.avanza.aboutdata.di

import com.avanza.aboutdata.repository.AboutUsRepository
import com.avanza.aboutdomain.repository.FetchAboutUsRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataModule {

    @Binds
    abstract fun bindAboutUsRepository(aboutUsRepository: AboutUsRepository): FetchAboutUsRepository
}