package com.avanza.aboutdomain.repository

import com.basedomain.Result

interface FetchAboutUsRepository {
    suspend fun fetchAboutUs(): Result<String>
}