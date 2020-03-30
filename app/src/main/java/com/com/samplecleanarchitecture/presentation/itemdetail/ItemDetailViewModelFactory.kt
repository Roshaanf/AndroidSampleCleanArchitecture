package com.com.samplecleanarchitecture.presentation.itemdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aapa.di.profile.scope.ItemDetailScope
import javax.inject.Inject

@ItemDetailScope
class ItemDetailViewModelFactory @Inject constructor(val viewModel: ItemDetailViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != ItemDetailViewModel::class.java)
            throw IllegalArgumentException("Unknown View model class")
        else
            return viewModel as T
    }
}