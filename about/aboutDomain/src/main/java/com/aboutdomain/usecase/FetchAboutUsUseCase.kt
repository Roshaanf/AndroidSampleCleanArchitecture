package com.aboutdomain.usecase

import com.aboutdomain.repository.FetchAboutUsRepository
import com.basedomain.DomainScope
import com.basedomain.Result
import com.basedomain.runOnBackgroundThread
import javax.inject.Inject

@DomainScope
class FetchAboutUsUseCase @Inject constructor(private val aboutUsRepository: FetchAboutUsRepository) {

    suspend operator fun invoke(): Result<String> =
        runOnBackgroundThread {
            aboutUsRepository.fetchAboutUs()
        }

}