package com.aboutdomain.di.require

import com.aboutdomain.repository.FetchAboutUsRepository


interface DataRequire {
    fun aboutUsRepository(): FetchAboutUsRepository
}