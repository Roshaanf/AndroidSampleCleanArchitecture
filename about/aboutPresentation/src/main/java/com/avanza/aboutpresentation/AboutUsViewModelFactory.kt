package com.avanza.aboutpresentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basepresentation.di.scope.PresentationScope
import javax.inject.Inject

@PresentationScope
class AboutUsViewModelFactory @Inject constructor(private val viewModel: AboutUsViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != AboutUsViewModel::class.java)
            throw IllegalArgumentException("Unknown View model class")
        else
            return viewModel as T
    }
}