package com.avanza.aboutdomain.di.require

import com.avanza.aboutdomain.repository.FetchAboutUsRepository

interface DataRequire {
    fun aboutUsRepository(): FetchAboutUsRepository
}