package com.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.basepresentation.base.BaseFragment
import com.presentation.databinding.FragmentItemDetailBinding
import com.presentation.di.PresentationInjector
import kotlinx.android.synthetic.main.fragment_item_detail.*
import javax.inject.Inject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ItemDetail : BaseFragment() {

    private lateinit var viewModel: ItemDetailViewModel

    @Inject
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

        PresentationInjector
            .create()
            .inject(this)

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
        progressBar.visibility=View.VISIBLE
    }

    override fun hideLoader() {
        progressBar.visibility=View.GONE
    }


}
