package com.com.samplecleanarchitecture.presentation.itemdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.com.samplecleanarchitecture.R
import com.com.samplecleanarchitecture.databinding.FragmentItemDetailBinding
import com.com.samplecleanarchitecture.presentation.base.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ItemDetail : BaseFragment() {

    lateinit var viewModel: ItemDetailViewModel
    lateinit var viewModelFactory: ItemDetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =
            DataBindingUtil.inflate<FragmentItemDetailBinding>(
                inflater,
                R.layout.fragment_item_detail,
                container,
                false
            )

        viewModel = attachViewModel(viewModelFactory)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.getRoot()
    }

    override fun setObservers() {
    }

    override fun initializeComponents() {
        observeUIEvents(viewModel)
    }

    override fun showLoader() {
    }

    override fun hideLoader() {
    }


}
