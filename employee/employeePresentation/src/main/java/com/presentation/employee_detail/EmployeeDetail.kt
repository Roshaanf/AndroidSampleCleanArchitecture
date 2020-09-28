package com.presentation.employee_detail


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.basepresentation.base.BaseFragment
import com.basepresentation.util.exhaustive
import com.presentation.R
import com.presentation.databinding.FragmentEmployeeDetailBinding
import com.presentation.di.PresentationInjector
import kotlinx.android.synthetic.main.fragment_employee_detail.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
internal class EmployeeDetail : BaseFragment() {

    private lateinit var viewModel: EmployeeDetailViewModel

    @Inject
    lateinit var viewModelFactory: EmployeeDetailViewModelFactory


    override fun initiateInjection() {
        PresentationInjector
            .buildEmployeeDetailComponent()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =
            DataBindingUtil.inflate<FragmentEmployeeDetailBinding>(
                inflater,
                R.layout.fragment_employee_detail,
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

        viewModel.handleIntent(arguments)
    }

    override fun showLoader() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progressBar.visibility = View.GONE
    }


}
