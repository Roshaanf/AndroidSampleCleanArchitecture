package com.aboutdata.repository

import com.aboutdomain.repository.FetchAboutUsRepository
import com.basedata.di.scope.DataScope
import com.basedomain.Result
import javax.inject.Inject

@DataScope
internal class AboutUsRepository @Inject constructor() : FetchAboutUsRepository {
    override suspend fun fetchAboutUs(): Result<String> =
        Result.Success("About Us")

}