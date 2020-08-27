package com.avanza.aboutpresentation

import com.avanza.aboutdomain.usecase.FetchAboutUsUseCase
import com.basepresentation.di.scope.PresentationScope
import javax.inject.Inject

@PresentationScope
class AboutUsViewModel @Inject constructor(private val fetchAboutUsUseCase: FetchAboutUsUseCase) {
}