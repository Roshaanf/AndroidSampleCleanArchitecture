package com.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basepresentation.di.scope.PresentationScope
import javax.inject.Inject

@PresentationScope
class ItemDetailViewModelFactory @Inject constructor(val viewModel: ItemDetailViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != ItemDetailViewModel::class.java)
            throw IllegalArgumentException("Unknown View model class")
        else
            return viewModel as T
    }
}