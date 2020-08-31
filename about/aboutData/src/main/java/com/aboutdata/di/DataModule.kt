package com.aboutdata.di

import com.aboutdata.repository.AboutUsRepository
import com.aboutdomain.repository.FetchAboutUsRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataModule {

    @Binds
    abstract fun bindAboutUsRepository(aboutUsRepository: AboutUsRepository): FetchAboutUsRepository
}