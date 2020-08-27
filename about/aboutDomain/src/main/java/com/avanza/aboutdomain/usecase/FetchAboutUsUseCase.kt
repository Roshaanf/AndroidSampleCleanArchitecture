package com.avanza.aboutdomain.usecase

import com.avanza.aboutdomain.repository.FetchAboutUsRepository
import com.basedomain.DomainScope
import com.basedomain.Result
import com.basedomain.runOnBackgroundThread
import javax.inject.Inject

@DomainScope
class FetchAboutUsUseCase @Inject constructor(private val aboutUsRepository: FetchAboutUsRepository) {

    suspend operator fun invoke(id: Int): Result<String> =
        runOnBackgroundThread {
            aboutUsRepository.fetchAboutUs()
        }

}